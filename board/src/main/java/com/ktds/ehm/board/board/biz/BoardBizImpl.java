package com.ktds.ehm.board.board.biz;

import java.util.ArrayList;
import java.util.List;

import com.ktds.ehm.board.board.dao.BoardDao;
import com.ktds.ehm.board.board.dao.BoardDaoImpl;
import com.ktds.ehm.board.board.vo.BoardSearchVO;
import com.ktds.ehm.board.board.vo.BoardVO;

/**
 * Created by Admin on 2017-02-17.
 */
public class BoardBizImpl implements BoardBiz {
    private BoardDao boardDao;

    public BoardBizImpl() {
        this.boardDao = new BoardDaoImpl();
    }

    @Override
    public BoardVO getOneArticle(int boardId) {
    	boardDao.addCount(boardId);
        return boardDao.selectOneArticle(boardId);
    }

    @Override
    public boolean writeArticle(BoardVO boardVO) {
        return boardDao.insertArticle(boardVO) > 0;
    }

    @Override
    public List<BoardVO> getAllArticles(BoardSearchVO boardSearchVO) {
    	
    	//게시글의 개수를 조회해 pager객체에 할당한다.
    	//getAllArticlesCount boardSearchVO 는 추후 사용//검색등등의 기능 붙일때..
    	int articleCount = boardDao.getAllArticlesCount(boardSearchVO);
    	boardSearchVO.getPager().setTotalArticleCount(articleCount);
    	
    	// 게시글의 개수가 0이라면, 비어있는 리스트를 리턴하고
    	if( articleCount == 0 ) {
    		return new ArrayList<BoardVO>();
    	}
    	else {
    	// 그렇지 않다면, getAllArticles();를 리턴한다.	
    		return boardDao.selectAllArticles(boardSearchVO);
    	}
    	
    }

    @Override
    public boolean removeArticle(int boardId) {
        return this.boardDao.deleteArticle(boardId) > 0 ;
    }

    @Override
    public boolean updateArticle(BoardVO boardVO) {
        return this.boardDao.updateArticle(boardVO) > 0;
    }
}
