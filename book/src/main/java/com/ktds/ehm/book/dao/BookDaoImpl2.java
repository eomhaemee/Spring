package com.ktds.ehm.book.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.ehm.book.vo.BookVO;


public class BookDaoImpl2 implements BookDao {

	@Override
	public List<BookVO> selectAllBooks() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle 드라이버로딩 실패 시스템 종료!");
			return null;
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		try {
			conn = DriverManager.getConnection(url, "BOOKSTORE", "book");
			
			String sql = "select * from book";
			stmt=  conn.prepareStatement(sql);
			
			
			rs = stmt.executeQuery();
		
			
			BookVO bookVO= null;
			List<BookVO> books = new ArrayList<BookVO>();
			
			while( rs.next() ){
				bookVO = new BookVO();
				bookVO.setBookId(rs.getInt("BOOK_ID"));
				bookVO.setBookNm(rs.getString("BOOK_NM"));
				bookVO.setBookSubNm(rs.getString("BOOK_SUB_NM"));
				bookVO.setIdx(rs.getString("IDX"));
				books.add(bookVO);
			}
			
			return books;
			
			
		} catch (SQLException e) {
			System.out.println("Oracle 인스턴스에 연결하지 못했습니다. 시스템 종료!");
			return null;
		}finally {
			try {
				if ( rs!= null){
					rs.close();
				}
			} catch (SQLException e) {}
			try {
				if( stmt != null ) {
					stmt.close();
				}
			} catch (SQLException e) {}
			try {
				if ( conn != null){
					conn.close();
				}
			} catch (SQLException e) {}
		}
	}

	@Override
	public BookVO selectOneBook(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBook(BookVO bookVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBook(int bookId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBook(BookVO bookVO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
