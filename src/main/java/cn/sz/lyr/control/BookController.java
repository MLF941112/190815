package cn.sz.lyr.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.sz.lyr.pojo.Book;
import cn.sz.lyr.service.IBookService;

@Controller
@RequestMapping("/bc")
public class BookController {
	@Autowired
	private IBookService bookservice;
	
	@RequestMapping(value="findall")
	public String showall(Model model) {
		List<Book>booklist=bookservice.findall();
		model.addAttribute("booklist",booklist);
		return "book_list";	
	}
	
	@RequestMapping(value="findbyid")
	public String findBookById(Integer bookid,Model model) {
		Book book=bookservice.findBookById(bookid);
		model.addAttribute("book", book);
		return "book_info";
	}
	
	@RequestMapping(value="addbook")
	public String addbook(Book book,HttpServletRequest request,@RequestParam MultipartFile pic) {
		System.out.println("接收日期:"+book.getPublicDate());
		System.out.println("book信息:"+book.getBookName());
		System.out.println("文件:"+pic.getOriginalFilename());
		try {
			
			//pic.transferTo(new File("D:\\e_pro\\HW\\src\\main\\webapp\\images",pic.getOriginalFilename()));
		
			InputStream is=pic.getInputStream();//获取绝对路径
			String realpath=request.getSession().getServletContext().getRealPath("/bookimg");
			
			String newfilename=UUID.randomUUID().toString();
			String endname=pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf(","));
			OutputStream os=new FileOutputStream(new File(realpath+"/"+newfilename+endname));
			
			FileCopyUtils.copy(is,os);
			book.setImgPath(newfilename+endname);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		//book.setImgPath(pic.getOriginalFilename());
		bookservice.addbook(book);
		return "redirect:/bc/findall";		
	}
}
