package com.ktds.ehm.myboard.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.ehm.myboard.biz.BoardBiz;
import com.ktds.ehm.myboard.biz.BoardBizImpl;
import com.ktds.ehm.myboard.vo.BoardVO;

public class ViewBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardBiz boardBiz;
	
    public ViewBoardListServlet() {
    	boardBiz = new BoardBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		List<BoardVO> myBoard = boardBiz.getAllBoard();
		request.setAttribute("myBoardList", myBoard);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
		dispatcher.forward(request, response);
	}

}
