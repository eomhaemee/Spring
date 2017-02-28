package com.ktds.ehm.board.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.ehm.board.board.biz.BoardBiz;
import com.ktds.ehm.board.board.biz.BoardBizImpl;
import com.ktds.ehm.board.board.vo.BoardVO;


public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private BoardBiz boardBiz;
   
    public ListServlet() {
       boardBiz = new BoardBizImpl();
    }

	//톰캣에게 request(URL정보등),response 를 보내거나 받음
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//imsi
		//HttpSession session = request.getSession();
		//session.invalidate();
		
		
		List<BoardVO> articleList = boardBiz.getAllArticles();
		request.setAttribute("articleList", articleList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/board/list.jsp");
		// 위 page를 전달할때 setAttribute 한 내용을 포함해서 보냄
		dispatcher.forward(request, response);
	}

}
