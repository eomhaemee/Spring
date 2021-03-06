package com.ktds.ehm.board.board.dao;

import java.util.List;

import com.ktds.ehm.board.board.vo.BoardSearchVO;
import com.ktds.ehm.board.board.vo.BoardVO;

/**
 * Created by Admin on 2017-02-17.
 */
public interface BoardDao {
	
	public int getAllArticlesCount(BoardSearchVO boardSearchVO);
	
	public List<BoardVO> selectAllArticles(BoardSearchVO boardSearchVO);
	
	public BoardVO selectOneArticle(int boardId);
	 
    public int insertArticle(BoardVO boardVO);
   
    public int deleteArticle(int boardId);
    public int updateArticle(BoardVO boardVO);
    public int addCount(int boardId);

}
