package com.ktds.ehm.board.board.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PrintUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PrintUserServlet() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		out.append("내가만든 서블릿 ");
		out.append(request.getContextPath());
		out.append("<br/> <h1>보일까? (태그 그대로 보이는군)</h1>");
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
