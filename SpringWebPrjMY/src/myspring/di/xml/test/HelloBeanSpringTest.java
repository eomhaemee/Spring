package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
public class HelloBeanSpringTest {
	@Autowired
	private ApplicationContext context;

	@Test
	public void bean1() {
		Hello hello = (Hello) context.getBean("hello");
		assertEquals("Hello Spring", hello.sayHello());
		hello.print();
		assertEquals("Hello Spring", context.getBean("printer").toString());

		Hello hello2 = context.getBean("hello", Hello.class);
		hello2.print();
		assertSame(hello, hello2);
	}

}