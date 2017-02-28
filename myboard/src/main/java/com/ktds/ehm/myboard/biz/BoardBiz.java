package com.ktds.ehm.myboard.biz;

import java.util.List;

import com.ktds.ehm.myboard.vo.BoardVO;

public interface BoardBiz {
	public List<BoardVO> getAllBoard();
	public BoardVO getOneBoard(int boardId);
	public boolean writeBoard(BoardVO boardVO);
	public boolean deleteBoard(int boardId);
	public boolean updateBoard(BoardVO boardVO);
	
}
