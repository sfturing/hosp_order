package cn.sfturing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sfturing.dao.BookDao;
import cn.sfturing.entity.Book;
import cn.sfturing.service.BookService;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	@Override
	public Book getById(long bookId) {
		// TODO Auto-generated method stub
		return bookDao.queryById(bookId);
	}

}
