package com.ktds.ehm.myboard.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.ehm.myboard.biz.BoardBiz;
import com.ktds.ehm.myboard.biz.BoardBizImpl;


public class DoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardBiz boardBiz;
       
    public DoDeleteServlet() {
    	boardBiz = new BoardBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardIdString = request.getParameter("boardId");
		int boardId = 0;
		try {
			boardId = Integer.parseInt(boardIdString);
		} catch (NumberFormatException e) {
			throw new RuntimeException("boardId 가져오기실패");
		}
		
		if (boardBiz.deleteBoard(boardId) ) {
			response.sendRedirect("/myboard/list");
		}else {
			response.sendRedirect("/myboard/detail");
		}
		
		
	}

}
