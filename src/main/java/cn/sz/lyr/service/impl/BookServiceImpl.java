package cn.sz.lyr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.lyr.dao.IBookDAO;
import cn.sz.lyr.pojo.Book;
import cn.sz.lyr.service.IBookService;
@Service
public class BookServiceImpl implements IBookService {
	@Autowired
	private IBookDAO bookdao;
	
	
	public List<Book> findall() {
		
		return bookdao.findallbook();
	}

	public Book findBookById(Integer bookid) {
		
		return bookdao.findBookById(bookid);
	}

	public void addbook(Book book) {
		bookdao.addbook(book);	
	}

}
