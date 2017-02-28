package com.ktds.ehm.board.board.biz;

import java.util.List;

import com.ktds.ehm.board.board.vo.BoardVO;

/**
 * Created by Admin on 2017-02-17.
 */
public interface BoardBiz {
    public boolean writeArticle(BoardVO boardVO);
    public List<BoardVO> getAllArticles();
    public BoardVO getOneArticle(int boardId);
    public boolean removeArticle(int boardId);

    public boolean updateArticle(BoardVO boardVO);

}
