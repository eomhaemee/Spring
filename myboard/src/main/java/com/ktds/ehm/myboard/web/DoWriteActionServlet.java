package com.ktds.ehm.myboard.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.ehm.myboard.biz.BoardBiz;
import com.ktds.ehm.myboard.biz.BoardBizImpl;
import com.ktds.ehm.myboard.vo.BoardVO;

public class DoWriteActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardBiz boardBiz;
	
    public DoWriteActionServlet() {
    	boardBiz = new BoardBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		BoardVO boardVO = new BoardVO();

		String content = request.getParameter("content");
		String writer = request.getParameter("writer");

		//enter변경
		content = content.replaceAll("\n", "<br/>");
		content = content.replaceAll("\r", "");
		boardVO.setContent(content);
		
		//ip 얻어오기
		String ip = request.getRemoteAddr();
		writer = writer + "(" + ip + ")";
		boardVO.setWriter(request.getParameter("writer"));
		
		boardVO.setSubject(request.getParameter("subject"));
		
		
		if( boardBiz.writeBoard(boardVO) ) {
			response.sendRedirect("/myboard/list");
		}else {
			response.sendRedirect("/myboard/write");
		}
	}

}
