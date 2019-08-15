package cn.sz.lyr.dao;

import java.util.List;

import cn.sz.lyr.pojo.Book;

public interface IBookDAO {

	public List<Book> findallbook();
	
	public Book findBookById(Integer bookid);
	
	public void addbook(Book book);
	
	public Double findPriceByBookid(Integer bookid);
}
