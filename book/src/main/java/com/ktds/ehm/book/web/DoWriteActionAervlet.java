package com.ktds.ehm.book.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.ehm.book.biz.BookBiz;
import com.ktds.ehm.book.biz.BookBizImpl;
import com.ktds.ehm.book.vo.BookVO;


public class DoWriteActionAervlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookBiz bookBiz;
	
    public DoWriteActionAervlet() {
    	bookBiz = new BookBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BookVO bookVO = new BookVO();

		String bookSubNm = request.getParameter("bookSubNm");
		bookSubNm.replaceAll("\n", "<\br>");
		bookSubNm.replaceAll("\r", "");
		
		bookVO.setBookSubNm(bookSubNm);
		bookVO.setBookNm(request.getParameter("bookNm"));
		bookVO.setIdx(request.getParameter("idx"));
		
		if ( bookBiz.writeBook(bookVO) ) {
			response.sendRedirect("/book/list");
		}else{
			response.sendRedirect("/book/write");
		}
		
	}

}
