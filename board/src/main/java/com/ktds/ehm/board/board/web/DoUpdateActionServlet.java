package com.ktds.ehm.board.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.ehm.board.board.biz.BoardBiz;
import com.ktds.ehm.board.board.biz.BoardBizImpl;
import com.ktds.ehm.board.board.vo.BoardVO;


public class DoUpdateActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private BoardBiz boardBiz;
	
	public DoUpdateActionServlet() {
		boardBiz= new BoardBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String content = request.getParameter("content");
		
		content = content.replaceAll("\n", "<br/>");
		content = content.replaceAll("\r", "");
		
		BoardVO boardVO = new BoardVO();
		String boardIdString = request.getParameter("boardId");
		boardVO.setSubject(request.getParameter("subject"));
		boardVO.setContent(content);

		System.out.println("수정boardId: "+ boardIdString);
		
		int boardId = 0;
		try {
			boardId = Integer.parseInt(boardIdString);
		} catch (NumberFormatException e) {
			throw new RuntimeException("게시판 id얻어오기실패 (update)");
		}
		
		boardVO.setBoardId(boardId);
		
		if (boardBiz.updateArticle(boardVO) ) {
			response.sendRedirect("/board/list");
		}else{
			response.sendRedirect("/board/update");
		}
	}

}
