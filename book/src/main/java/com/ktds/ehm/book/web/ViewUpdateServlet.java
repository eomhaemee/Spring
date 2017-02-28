package com.ktds.ehm.book.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.ehm.book.biz.BookBiz;
import com.ktds.ehm.book.biz.BookBizImpl;
import com.ktds.ehm.book.vo.BookVO;

public class ViewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookBiz bookBiz;
       
    public ViewUpdateServlet() {
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
			throw new RuntimeException("View update bookId얻어오기 실패");
		}
		
		BookVO  bookVO = bookBiz.getOneBook(bookId);
		
		String bookSubNm = bookVO.getBookSubNm();
		
		bookSubNm.replaceAll("</br>", "\n");
		bookVO.setBookSubNm(bookSubNm);
		
		request.setAttribute("book", bookVO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/update.jsp");
		dispatcher.forward(request, response);
	}

}
