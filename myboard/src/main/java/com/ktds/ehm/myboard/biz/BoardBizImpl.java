package com.ktds.ehm.myboard.biz;

import java.util.List;

import com.ktds.ehm.myboard.dao.BoardDao;
import com.ktds.ehm.myboard.dao.BoardDaoImpl;
import com.ktds.ehm.myboard.vo.BoardVO;

public class BoardBizImpl implements BoardBiz {

	private BoardDao boardDao;
	
	public BoardBizImpl() {	
		boardDao = new BoardDaoImpl();
	}
	@Override
	public List<BoardVO> getAllBoard(){
		return boardDao.selectAllBoard();
	}

	@Override
	public BoardVO getOneBoard(int boardId) {
		return boardDao.selectOneBoard(boardId);
	}
	@Override
	public boolean writeBoard(BoardVO boardVO) {
		return boardDao.insertBoard(boardVO) > 0;
	}
	@Override
	public boolean deleteBoard(int boardId) {
		return boardDao.deleteBoard(boardId) > 0;
	}
	@Override
	public boolean updateBoard(BoardVO boardVO) {
		return boardDao.updateBoard(boardVO) > 0;
	}


}
