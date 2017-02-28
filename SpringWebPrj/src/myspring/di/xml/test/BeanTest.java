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
		//1. Spring bean container ����
		context = new GenericXmlApplicationContext("config/beans.xml");
		
	}
	@Test
	public void helloAnnot(){
		Hello hello = context.getBean("helloA", Hello.class);
		hello.print();
		assertEquals("Hello ������̼�", hello.getPrinter().toString());
		
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
		
		//static ���� �����ؼ� Assert�� ���� �ص� ��
		assertEquals("Hello ȫ�浿", printer.toString());
		assertEquals(3, hello2.getNames().size());
		for (String value : hello2.getNames()) {
			System.out.println(value);
		}
	}

	@Test @Ignore
	public void hello1(){
		//1. Spring bean contaiter ����
		ApplicationContext context = new GenericXmlApplicationContext("config/beans.xml");
		//2.bean�� ��������
		//���1
		Hello hello1 = (Hello) context.getBean("hello");
		//���2
		Hello hello2 = context.getBean("hello", Hello.class);
		
		//�ΰ�ü�� �ּҰ� ������ Ȯ�� (������ �����) 
		//��� ����ΰź��� ���� �ּҰ� => ���: spring �� Singleton ���(��ü�� �ѹ�������)���� ��ü�� �����ϴ±�
		//Assert.assertSame(hello1, hello2);
		assertSame(hello1, hello2);
	}
	
}
