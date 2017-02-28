package com.ktds.ehm.common.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.ehm.board.user.vo.UsersVO;

public class LoginSessionCheckFilter implements Filter {

	public LoginSessionCheckFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httprequest = (HttpServletRequest) request;
		UsersVO usersVO = (UsersVO) httprequest.getSession().getAttribute("_USER_");
		
		if( usersVO == null ){
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("/board/user/login");
			//void 인경우 return 의 의미는 종료
			return;
		}
	
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
