package com.ktds.ehm.myboard.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.ehm.myboard.biz.BoardBiz;
import com.ktds.ehm.myboard.biz.BoardBizImpl;
import com.ktds.ehm.myboard.vo.BoardVO;


public class ViewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardBiz boardBiz;
       
    public ViewUpdateServlet() {
    	boardBiz = new BoardBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String boardIdString = request.getParameter("boardId");
		
		int boardId = 0;
		
		try {
			boardId = Integer.parseInt(boardIdString);
		} catch (NumberFormatException e) {
			throw new RuntimeException("boardId 가져오기실패");
		}
		
		BoardVO boardVO = boardBiz.getOneBoard(boardId);
		
		String content = boardVO.getContent();
		
		content = content.replaceAll("<br/>", "\n");
		
		request.setAttribute("board", boardVO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
		dispatcher.forward(request, response);
		
	}

}
