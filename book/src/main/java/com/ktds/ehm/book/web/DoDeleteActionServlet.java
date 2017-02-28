package com.ktds.ehm.book.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.ehm.book.biz.BookBiz;
import com.ktds.ehm.book.biz.BookBizImpl;


public class DoDeleteActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookBiz bookBiz;
       
    public DoDeleteActionServlet() {
    	bookBiz = new BookBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bookId = 0 ;
		try{
			bookId = Integer.parseInt(request.getParameter("bookId"));
		}catch (NumberFormatException e) {
			throw new RuntimeException("delete bookId얻어오기 실패");
		}
		
		if ( bookBiz.deleteBook(bookId) ){
			response.sendRedirect("/book/list");
		}else{
			response.sendRedirect("/book/write");
		}
	}

}
