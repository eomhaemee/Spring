package myspring.di.xml.test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.annot.Hello;
import myspring.di.annot.Printer;
import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
public class BeanSpringTest {
	@Autowired
	ApplicationContext context;
	
	@Autowired
	@Qualifier("helloA")
	Hello hello;
	
	@Autowired
	@Qualifier("stringPrinterA")
	Printer printer;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSession session;
	
	@Autowired
	UserService service;
	
	@Test
	public void aop(){
		List<UserVO> list = service.getUserList();
		for (UserVO userVO : list) {
			System.out.println(userVO);
		}
	}
	
	@Test@Ignore
	public void mybatis(){
		List<UserVO> list = session.selectList("userNS.selectUserList");
		
		for (UserVO userVO : list) {
			System.out.println(userVO);
		}
		//int cnt = session.update("userNS.insertUser", new UserVO("ehm","혜미","여","서울"));
		//System.out.println(cnt);
		
		//System.out.println(session.getClass().getName());
		//context.getBean("sqlSessionFactory");
		//System.out.println(context.getBean("sqlSessionFactory").getClass().getName());
	}
	
	
	@Test@Ignore
	public void db(){
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test@Ignore
	public void bean1(){
		//System.out.println(context.getClass().getName());
		//System.out.println(hello.getClass().getName());
		hello.sayHello();
		Assert.assertEquals("Hello 어노테이션", hello.sayHello());
		hello.print();
		Assert.assertEquals("Hello 어노테이션", printer.toString());
	}
}
