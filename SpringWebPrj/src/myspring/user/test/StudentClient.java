package myspring.user.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.vo.DeptVO;
import myspring.user.vo.StudentVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
public class StudentClient {
	
	@Autowired
	SqlSession session;
	

	@Test
	public void student() {
		List<StudentVO> list = session.selectList("studentNS.selectStudentDeptById");
		for (StudentVO student : list) {
			System.out.println(student);
		}
		
		StudentVO stu = new StudentVO(999, "�ڼ�",21, "3�г�","�ְ�",new DeptVO(30));
		//session.update("studentNS.insertStudent", stu);
	
		stu = new StudentVO(1003, "�ڼ���2",22, "2�г�","�ְ�2",new DeptVO(40));
		//session.update("studentNS.updateStudent", stu);
		
		StudentVO	student2  = session.selectOne("studentNS.selectStudentByName", "��");
		System.out.println(student2);
		

		
	}
	
}