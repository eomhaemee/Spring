package com.ktds.ehm.book.dao;

import java.util.List;

import com.ktds.ehm.book.vo.BookVO;

public interface BookDao {
	public List<BookVO> selectAllBooks();
	public BookVO selectOneBook(int bookId);
	public int insertBook(BookVO bookVO);
	public int deleteBook(int bookId);
	public int updateBook(BookVO bookVO);

}
