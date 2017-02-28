package com.ktds.ehm.book.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktds.ehm.book.vo.BookVO;
import com.ktds.ehm.dao.support.JDBCDaoSupport;
import com.ktds.ehm.dao.support.QueryHandler;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QDecoderStream;

public class BookDaoImpl extends JDBCDaoSupport implements BookDao {

	@Override
	public List<BookVO> selectAllBooks() {
		 return selectList(new QueryHandler() {
			
			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT  BOOK_ID,    ");
			    query.append("     BOOK_NM,        ");
			    query.append("     BOOK_SUB_NM,    ");
			    query.append("     IDX             ");
		        query.append(" FROM    BOOK      ");
		        query.append(" ORDER BY BOOK_ID ");
				return query.toString();
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
			}
			
			@Override
			public Object getData(ResultSet rs) {
				BookVO bookVO = new BookVO();
				
				try {
					bookVO.setBookId(rs.getInt("BOOK_ID"));
					bookVO.setBookNm(rs.getString("BOOK_NM"));
					bookVO.setBookSubNm(rs.getString("BOOK_SUB_NM"));
					bookVO.setIdx(rs.getString("IDX"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return bookVO;
			}
		});
	}

	@Override
	public BookVO selectOneBook(int bookId) {
		return (BookVO) selectOne(new QueryHandler() {
			
			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT  BOOK_ID,    ");
			    query.append("     BOOK_NM,        ");
			    query.append("     BOOK_SUB_NM,    ");
			    query.append("     IDX             ");
		        query.append(" FROM    BOOK      ");
		        query.append(" WHERE    BOOK_ID = ?      ");
		        query.append(" ORDER BY BOOK_ID ");
				return query.toString();
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				stmt.setInt(1, bookId);
			}
			
			@Override
			public Object getData(ResultSet rs) {
				BookVO bookVO = new BookVO();
				try {
					bookVO.setBookId(rs.getInt("BOOK_ID"));
					bookVO.setBookNm(rs.getString("BOOK_NM"));
					bookVO.setBookSubNm(rs.getString("BOOK_SUB_NM"));
					bookVO.setIdx(rs.getString("IDX"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return bookVO;
			}
		});
	}

	@Override
	public int insertBook(BookVO bookVO) {
		return update(new QueryHandler() {
			
			@Override
			public String preparedQuery() {
				   StringBuffer query = new StringBuffer();
	                query.append( "INSERT INTO BOOK (");
	                query.append( "                   BOOK_ID ");
	                query.append( "                   , BOOK_NM ");
	                query.append( "                   , BOOK_SUB_NM ");
	                query.append( "                   , IDX ");
	                query.append( "                   ) ");
	                query.append( "VALUES             (");
	                query.append( "                     BOOK_ID_SEQ.NEXTVAL ");
	                query.append( "                    ,? ");
	                query.append( "                    ,? ");
	                query.append( "                    ,? ");
	                query.append( "                   ) ");
	                return query.toString();
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				stmt.setString(1, bookVO.getBookNm());
				stmt.setString(2, bookVO.getBookSubNm());
				stmt.setString(3, bookVO.getIdx());
			}
			
			@Override
			public Object getData(ResultSet rs) {
				return null;
			}
		});
	
	}

	@Override
	public int deleteBook(int bookId) {
		return update(new QueryHandler() {
			
			@Override
			public String preparedQuery() {
				 StringBuffer query = new StringBuffer();
				  query.append(" DELETE   BOOK ");
	              query.append(" WHERE    BOOK_ID = ? ");

				return query.toString();
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				stmt.setInt(1, bookId);;
				
			}
			
			@Override
			public Object getData(ResultSet rs) {
				return null;
			}
		});

	}

	@Override
	public int updateBook(BookVO bookVO) {
		return update(new QueryHandler() {
			@Override
			public String preparedQuery() {
				 StringBuffer query = new StringBuffer();
				query.append(" UPDATE   BOOK              ");
				query.append(" SET	 	BOOK_NM	= ?   ");
				query.append("    	    , BOOK_SUB_NM	= ?   ");
				query.append("    	    , IDX	= ?   ");
				query.append(" WHERE    BOOK_ID = ?        ");
				
			
				
				return query.toString();
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				stmt.setString(1, bookVO.getBookNm());
				stmt.setString(2, bookVO.getBookSubNm());
				stmt.setString(3, bookVO.getIdx());
				stmt.setInt(4, bookVO.getBookId());
				
			}
			
			@Override
			public Object getData(ResultSet rs) {
				return null;
			}
		});

	}

	
}
