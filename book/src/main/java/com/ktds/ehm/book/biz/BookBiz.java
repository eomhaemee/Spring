package com.ktds.ehm.book.biz;

import java.util.List;

import com.ktds.ehm.book.vo.BookVO;

public interface BookBiz {
	public List<BookVO> getAllBooks();
	public BookVO getOneBook(int bookId);
	public boolean writeBook(BookVO bookVO);
	public boolean deleteBook(int bookId);
	public boolean updateBook(BookVO bookVO);
}
