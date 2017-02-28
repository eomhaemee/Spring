package com.ktds.ehm.myboard.dao;

import java.util.List;

import com.ktds.ehm.myboard.vo.BoardVO;

public interface BoardDao {
	public int insertBoard(BoardVO boardVO);
	public List<BoardVO> selectAllBoard();
	public BoardVO selectOneBoard(int boardId);
	public int deleteBoard(int boardId);
	public int updateBoard(BoardVO boardVO);
}
