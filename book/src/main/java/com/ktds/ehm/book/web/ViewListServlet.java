package com.ktds.ehm.book.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.ehm.book.biz.BookBiz;
import com.ktds.ehm.book.biz.BookBizImpl;
import com.ktds.ehm.book.vo.BookVO;

public class ViewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookBiz bookBiz;
	
	public ViewListServlet() {
		bookBiz = new BookBizImpl();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<BookVO> books = bookBiz.getAllBooks();

		request.setAttribute("books", books);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/list.jsp");
		dispatcher.forward(request, response);
	}

}
