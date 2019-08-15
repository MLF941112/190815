package cn.sz.lyr.service;

import java.util.List;

import cn.sz.lyr.pojo.Book;

public interface IBookService {

	public List<Book> findall();
	
	public Book findBookById(Integer bookid);
	
	public void addbook(Book book);
}
