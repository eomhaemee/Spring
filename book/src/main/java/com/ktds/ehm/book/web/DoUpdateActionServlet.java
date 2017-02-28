package com.ktds.ehm.book.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.ehm.book.biz.BookBiz;
import com.ktds.ehm.book.biz.BookBizImpl;
import com.ktds.ehm.book.vo.BookVO;


public class DoUpdateActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookBiz bookBiz;
	
    public DoUpdateActionServlet() {
    	bookBiz = new BookBizImpl();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookVO bookVO = new BookVO();
		
		int bookId = 0 ;
		try{
			bookId = Integer.parseInt(request.getParameter("bookId"));
		}catch (NumberFormatException e) {
			throw new RuntimeException("update bookId얻어오기 실패");
		}
		
		String bookSubNm = request.getParameter("bookSubNm");
		bookSubNm.replaceAll("\n", "<\br>");
		bookSubNm.replaceAll("\r", "");
		
		bookVO.setBookSubNm(bookSubNm);
		
		bookVO.setBookId(bookId);
		bookVO.setBookNm(request.getParameter("bookNm"));
		bookVO.setIdx(request.getParameter("idx"));
		
		if ( bookBiz.updateBook(bookVO) ) {
			response.sendRedirect("/book/list");
		}else {
			response.sendRedirect("/book/update");
		}
	
	}

}
