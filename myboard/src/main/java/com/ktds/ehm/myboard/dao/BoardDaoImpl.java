package com.ktds.ehm.myboard.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktds.ehm.dao.support.JDBCDaoSupport;
import com.ktds.ehm.dao.support.QueryHandler;
import com.ktds.ehm.dao.support.annotation.BindData;
import com.ktds.ehm.myboard.vo.BoardVO;

public class BoardDaoImpl extends JDBCDaoSupport  implements BoardDao{

	@Override
	public int insertBoard(BoardVO boardVO) {
		return update(new QueryHandler() {
			
			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();
                query.append( "INSERT INTO BOARD (");
                query.append( "                   BOARD_ID ");
                query.append( "                   , SUBJECT ");
                query.append( "                   , CONTENT ");
                query.append( "                   , WRITER ");
                query.append( "                   , LIKE_COUNT ");
                query.append( "                   , WRITE_DATE ");
                query.append( "                   ) ");
                query.append( "VALUES             (");
                query.append( "                     BOARD_ID_SEQ.NEXTVAL ");
                query.append( "                    ,? ");
                query.append( "                    ,? ");
                query.append( "                    ,? ");
                query.append( "                    ,0 ");
                query.append( "                    ,SYSDATE ");
                query.append( "                   ) ");
                return query.toString();
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				stmt.setString(1, boardVO.getSubject());
				stmt.setString(2, boardVO.getContent());
				stmt.setString(3, boardVO.getWriter());
				
			}
			
			@Override
			public Object getData(ResultSet rs) {
				
				return null;
			}
		});
	}

	@Override
	public List<BoardVO> selectAllBoard() {
		
		return selectList(new QueryHandler() {
			
			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT BOARD_ID ");
				query.append("        , SUBJECT ");
				query.append("        , WRITER ");
				query.append("        , LIKE_COUNT ");
				query.append("        , TO_CHAR(WRITE_DATE,'YYYY.MM.DD') WRITE_DATE");
				query.append(" FROM  BOARD ");
				query.append(" ORDER BY BOARD_ID DESC ");
				return query.toString();
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
			}
			
			@Override
			public Object getData(ResultSet rs) {
				BoardVO boardVO = new BoardVO();
				try {
					boardVO.setBoardId(rs.getInt("BOARD_ID"));
					boardVO.setSubject(rs.getString("SUBJECT"));
					boardVO.setWriter(rs.getString("WRITER"));
					boardVO.setLikeCount(rs.getInt("LIKE_COUNT"));
					boardVO.setWriteDate(rs.getString("WRITE_DATE"));
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				return boardVO;
			}
		});
	}

	@Override
	public BoardVO selectOneBoard(int boardId) {
		
		return (BoardVO) selectOne(new QueryHandler() {
			
			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT BOARD_ID ");
				query.append("        , SUBJECT ");
				query.append("        , WRITER ");
				query.append("        , CONTENT ");
				query.append("        , LIKE_COUNT ");
				query.append("        , TO_CHAR(WRITE_DATE,'YYYY.MM.DD') WRITE_DATE");
				query.append(" FROM  BOARD ");
				query.append(" WHERE BOARD_ID = ? ");
				query.append(" ORDER BY BOARD_ID DESC ");
				
				return query.toString();
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
			
				stmt.setInt(1, boardId);
				
			}
			
			@Override
			public Object getData(ResultSet rs) {
				BoardVO boardVO = new BoardVO();
				
				try {
					boardVO.setBoardId(rs.getInt("BOARD_ID"));
					boardVO.setSubject(rs.getString("SUBJECT"));
					boardVO.setWriter(rs.getString("WRITER"));
					boardVO.setContent(rs.getString("CONTENT"));
					boardVO.setLikeCount(rs.getInt("LIKE_COUNT"));
					boardVO.setWriteDate(rs.getString("WRITE_DATE"));
				} catch (SQLException e) {}

				return boardVO;
			}
		});
		

	}

	@Override
	public int deleteBoard(int boardId) {
		return update(new QueryHandler() {
			
			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();
				query.append(" DELETE   BOARD ");
	            query.append(" WHERE    BOARD_ID = ? ");
				return query.toString();
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				stmt.setInt(1, boardId);
				
			}
			
			@Override
			public Object getData(ResultSet rs) {
				
				return null;
			}
		});

	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		
		return update(new QueryHandler() {
			
			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE   BOARD              ");
				query.append(" SET	 	      SUBJECT	= ?   ");
				query.append("    	        , CONTENT	= ?   ");
				query.append(" WHERE    BOARD_ID = ?        ");
				return query.toString();
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				stmt.setString(1, boardVO.getSubject());
				stmt.setString(2, boardVO.getContent());
				stmt.setInt(3, boardVO.getBoardId());
				
			}
			
			@Override
			public Object getData(ResultSet rs) {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}

		

}
