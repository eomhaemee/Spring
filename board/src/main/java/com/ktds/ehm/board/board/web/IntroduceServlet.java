package com.ktds.ehm.board.board.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.ehm.vo.IntroduceVO;

import oracle.net.aso.i;


public class IntroduceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public IntroduceServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/me.jsp");
		
		
		IntroduceVO introduceVO = new IntroduceVO();
		introduceVO.setName("혜미");
		introduceVO.setAddr("이문동");
		introduceVO.setHobby("피아노");
		introduceVO.setAge(20);
		
		List<IntroduceVO> introduceList = new ArrayList<IntroduceVO>();
		introduceList.add(introduceVO);
		introduceList.add(introduceVO);
		introduceList.add(introduceVO);
		introduceList.add(introduceVO);
		introduceList.add(introduceVO);
		
		
		
		request.setAttribute("introduceList", introduceList);
		
		request.setAttribute("introduce", introduceVO);
		
		
		dispatcher.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
