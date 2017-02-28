package com.ktds.ehm.myboard.web;

import java.io.IOException;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.ehm.myboard.biz.BoardBiz;
import com.ktds.ehm.myboard.biz.BoardBizImpl;
import com.ktds.ehm.myboard.vo.BoardVO;

public class DoUpdateActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardBiz boardBiz;

	public DoUpdateActionServlet() {
		boardBiz = new BoardBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		BoardVO boardVO = new BoardVO();
		String boardIdString = request.getParameter("boardId");
		String content = request.getParameter("content");

		int boardId = 0;
		try {
			boardId = Integer.parseInt(boardIdString);
		} catch (NumberFormatException e) {
			throw new RuntimeException("boardId 가져오기실패");
		}

		content = content.replaceAll("<\n>", "<br/>");
		content = content.replaceAll("\r", "");

		boardVO.setBoardId(boardId);
		boardVO.setContent(content);
		boardVO.setSubject(request.getParameter("subject"));

		System.out.println("[boardId] "+ boardId+ "[content] "+ content+"[subject] "+ request.getParameter("subject") );
		
		if ( boardBiz.updateBoard(boardVO) ) {
			response.sendRedirect("/myboard/list");
		}else{
			response.sendRedirect("/myboard/update");
		}

	}

}
