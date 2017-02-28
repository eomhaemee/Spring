package com.ktds.ehm.board.user.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.ehm.board.user.biz.UsersBiz;
import com.ktds.ehm.board.user.biz.UsersBizImpl;
import com.ktds.ehm.board.user.vo.UsersVO;


public class DoSignInActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersBiz usersBiz;
	
    public DoSignInActionServlet() {
    	usersBiz = new UsersBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기");
		UsersVO usersVO = new UsersVO();
		
		usersVO.setUserId(request.getParameter("userId"));
		usersVO.setUserPassword(request.getParameter("userPassword"));

		UsersVO user = usersBiz.getOneUsers(usersVO);
		
		if ( user == null) {
			response.sendRedirect("/board/user/login");
		}else{
			//session container가져오기
			//브라우저에 JSESSION_ID를 넘김
			HttpSession session = request.getSession();
			

			//session 키를 앞뒤로 _를 붙여줌
			session.setAttribute("_USER_", user);	


			System.out.println("id: " + user.getUserId() + "pw: " +user.getUserPassword() 
			+ "name:" + user.getUserName());
			response.sendRedirect("/board/list");
		}

		/*
		request.setAttribute("user", user);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/user/list.jsp");
		// 위 page를 전달할때 setAttribute 한 내용을 포함해서 보냄
		dispatcher.forward(request, response);
		*/
		
	}

}
