package com.ktds.ehm.book.biz;

import java.util.List;

import com.ktds.ehm.book.dao.BookDao;
import com.ktds.ehm.book.dao.BookDaoImpl;
import com.ktds.ehm.book.dao.BookDaoImpl2;
import com.ktds.ehm.book.vo.BookVO;

public class BookBizImpl implements BookBiz{
	private BookDao bookDao;
	private BookDao bookDao2;
	
	public BookBizImpl() {
		bookDao = new BookDaoImpl();
		bookDao2 = new BookDaoImpl2();
		
	}

	@Override
	public List<BookVO> getAllBooks() {		
		return bookDao2.selectAllBooks();
	}

	@Override
	public BookVO getOneBook(int bookId) {
		return bookDao.selectOneBook(bookId);
	}

	@Override
	public boolean writeBook(BookVO bookVO) {
		// TODO Auto-generated method stub
		return bookDao.insertBook(bookVO) > 0;
	}

	@Override
	public boolean deleteBook(int bookId) {
		// TODO Auto-generated method stub
		return bookDao.deleteBook(bookId)>0;
	}

	@Override
	public boolean updateBook(BookVO bookVO) {
		// TODO Auto-generated method stub
		return bookDao.updateBook(bookVO)>0;
	}

}
