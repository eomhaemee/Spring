package myspring.user.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.service.UserService;
import myspring.user.vo.PersonVO;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
public class UserClient {
	@Autowired
	ApplicationContext context;
	@Autowired
	UserService service;
	
	@Autowired
	SqlSession session;
	
	@Test @Ignore
	public void insertSEQ() {
		int cnt = session.update("userNS.insertPerson", new PersonVO("9407231634744", "둘리", "경기", "1234"));
		System.out.println(cnt);
	}
	
	@Test @Ignore
	public void updateUserTest() {
		service.updateUser(new UserVO("polar", "연아2", "여2", "경기2"));
		System.out.println(service.getUser("polar"));
	}

	@Test @Ignore
	public void deleteUserTest() {
		service.deleteUser("polar");

		for (UserVO user : service.getUserList()) {
			System.out.println(user);
		}
	}
	

	@Test
	@Ignore
	public void insertUserTest() {
		service.insertUser(new UserVO("polar", "연아", "여", "경기"));

		for (UserVO user : service.getUserList()) {
			System.out.println(user);
		}
	}

	@Test
	//@Ignore
	public void getUserTest() {
		UserVO user = service.getUser("gildong");
		System.out.println("User 정보 : " + user);
		assertEquals("홍길동", user.getName());
	}

	@Test
	@Ignore
	public void dataSourceTest() {
		DataSource ds = (DataSource) context.getBean("dataSource");
		try {
			System.out.println(ds.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
