package myspring.di.xml.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.annot.Hello;
import myspring.di.annot.Printer;

public class BeanTest {
	
	ApplicationContext context;
	
	@Before
	public void init(){
		//1. Spring bean container 생성
		context = new GenericXmlApplicationContext("config/beans.xml");
		
	}
	@Test
	public void helloAnnot(){
		Hello hello = context.getBean("helloA", Hello.class);
		hello.print();
		assertEquals("Hello 어노테이션", hello.getPrinter().toString());
		
	}
	
	@Test@Ignore
	public void helloC(){
		Hello hello2 = context.getBean("helloC", Hello.class);
		hello2.print();
	}
	
	@Test@Ignore
	public void hello2(){
		Hello hello2 = context.getBean("hello", Hello.class);
		hello2.print();
		Printer printer = context.getBean("stringPrinter", Printer.class);
		System.out.println(printer.toString());
		
		//static 으로 선언해서 Assert는 빼고 해도 됨
		assertEquals("Hello 홍길동", printer.toString());
		assertEquals(3, hello2.getNames().size());
		for (String value : hello2.getNames()) {
			System.out.println(value);
		}
	}

	@Test @Ignore
	public void hello1(){
		//1. Spring bean contaiter 생성
		ApplicationContext context = new GenericXmlApplicationContext("config/beans.xml");
		//2.bean을 가져오기
		//방법1
		Hello hello1 = (Hello) context.getBean("hello");
		//방법2
		Hello hello2 = context.getBean("hello", Hello.class);
		
		//두객체가 주소가 같은지 확인 (같으면 녹색바) 
		//결과 녹색인거보니 같은 주소값 => 결론: spring 은 Singleton 방식(객체를 한번만생성)으로 객체를 관리하는군
		//Assert.assertSame(hello1, hello2);
		assertSame(hello1, hello2);
	}
	
}
