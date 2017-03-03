package com.ktds.ehm.board.board.biz;

import java.util.List;

import com.ktds.ehm.board.board.vo.BoardSearchVO;
import com.ktds.ehm.board.board.vo.BoardVO;

/**
 * Created by Admin on 2017-02-17.
 */
public interface BoardBiz {
	
	public List<BoardVO> getAllArticles(BoardSearchVO boardSearchVO);
    public boolean writeArticle(BoardVO boardVO);
    
    public BoardVO getOneArticle(int boardId);
    public boolean removeArticle(int boardId);

    public boolean updateArticle(BoardVO boardVO);

}
