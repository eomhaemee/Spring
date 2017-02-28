package com.ktds.ehm.board.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.ehm.board.board.biz.BoardBiz;
import com.ktds.ehm.board.board.biz.BoardBizImpl;
import com.ktds.ehm.board.board.vo.BoardVO;
import com.ktds.ehm.board.user.vo.UsersVO;


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
		
		//String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		//ip 얻어오기
		//String ip = request.getRemoteAddr();
		//내정보는 session정보 꺼를 사용함 default: 30분 이후에 session 끊김
		HttpSession session = request.getSession();
		UsersVO usersVO = (UsersVO) session.getAttribute("_USER_");
		
		//String writer = usersVO.getUserName() ;
		String ip = request.getRemoteAddr();
		//writer = writer + "(" + ip + ")";
		//System.out.println("writer: "+writer  + " subject "+subject+ " content "+content );
		
		//replaceAll : 찾아 바꾸기,정규 표현식써서 바꾸기도 가능
		//replace:찾아 바꾸기
		//윈도우에서 enter key는 \n\r html <br/>로 바꾸기
		
		content = content.replaceAll("\n", "<br/>");
		content = content.replaceAll("\r", "");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setWriter(usersVO.getUserId());
		boardVO.setSubject(subject);
		boardVO.setContent(content);
		boardVO.setIp(ip);
		

		
		if( boardBiz.writeArticle(boardVO) ) {
			//글쓰기성공이면  list페이지로 이동한다.
			response.sendRedirect("/board/list");
		}else {
			//실패이면 write페이지로 이동한다.
			response.sendRedirect("/board/write");
		}
		
		
	}

}
