package ehmspring.di.xml.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ehmspring.di.xml.Hello;
import ehmspring.di.xml.Printer;

public class BeanTest {
	
	ApplicationContext context;
	
	@Before
	public void init(){
		context = new GenericXmlApplicationContext("config/beans.xml");
	}
	@Test
	public void helloXml(){
		Hello hello2 = context.getBean("hello", Hello.class);
		hello2.print();
		Printer printer = context.getBean("stringPrinter", Printer.class);	
		assertEquals("Hello EHM", printer.toString());
	}
	
}
