package com.ktds.ehm.board.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.ehm.board.board.biz.BoardBiz;
import com.ktds.ehm.board.board.biz.BoardBizImpl;


public class DoDeleteActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardBiz boardBiz;
	
    public DoDeleteActionServlet() {
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
			throw new RuntimeException("boardId 를 가져오지 못했습니다(delete)");
		}
		
	//	System.out.println("boardId: " + boardId);
		
		
		if( boardBiz.removeArticle(boardId) ) {
			response.sendRedirect("/board/list");
		}else {
			response.sendRedirect("/board/detail");
		}
		
		
		
	}

}
