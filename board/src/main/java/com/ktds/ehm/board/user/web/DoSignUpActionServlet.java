package com.ktds.ehm.board.user.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.ehm.board.user.biz.UsersBiz;
import com.ktds.ehm.board.user.biz.UsersBizImpl;
import com.ktds.ehm.board.user.vo.UsersVO;


public class DoSignUpActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersBiz usersBiz;
	
	public DoSignUpActionServlet() {
		usersBiz = new UsersBizImpl();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsersVO usersVO = new UsersVO();

		usersVO.setUserId(request.getParameter("userId"));
		usersVO.setUserPassword(request.getParameter("userPassword"));
		usersVO.setUserName(request.getParameter("userName"));
		
		if ( usersBiz.signUpUser(usersVO) ) {
			//contextpath부터 적어주기
			
			response.sendRedirect("/board/user/login");
		}else {
			response.sendRedirect("/board/user/signup");
		}
	}

}
