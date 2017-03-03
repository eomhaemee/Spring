package com.ktds.ehm.board.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.ehm.board.board.biz.BoardBiz;
import com.ktds.ehm.board.board.biz.BoardBizImpl;
import com.ktds.ehm.board.board.vo.BoardSearchVO;
import com.ktds.ehm.board.board.vo.BoardVO;
import com.ktds.ehm.common.web.pager.ClassicPageExplorer;
import com.ktds.ehm.common.web.pager.PageExplorer;
import com.ktds.ehm.common.web.pager.Pager;
import com.ktds.ehm.common.web.pager.PagerFactory;


public class ViewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private BoardBiz boardBiz;
   
    public ViewListServlet() {
       boardBiz = new BoardBizImpl();
    }

	//톰캣에게 request(URL정보등),response 를 보내거나 받음
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Paging Start..pageNo 안넘겨주면 0 으로 세팅함
		String pageNo= request.getParameter("pageNo");
		Pager pager = PagerFactory.getPager(Pager.ORACLE);
		pager.setPageNumber(pageNo);
		
		BoardSearchVO searchVO = new BoardSearchVO();
		searchVO.setPager(pager);
		List<BoardVO> articleList = boardBiz.getAllArticles(searchVO);
		
		//아래단에 page번호들 만드는 script포함 pages 에는 html이 리턴됨
		PageExplorer pageExplorer = new ClassicPageExplorer(pager);
		String pages = pageExplorer.getPagingList("pageNo", "[@]", "PREV", "NEXT", "searchForm");		
		request.setAttribute("pager",pages);
		//Paging End..
		
		request.setAttribute("articleList", articleList);
		request.setAttribute("count", pager.getTotalArticleCount());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/board/list.jsp");
		// 위 page를 전달할때 setAttribute 한 내용을 포함해서 보냄
		dispatcher.forward(request, response);
	}

}
