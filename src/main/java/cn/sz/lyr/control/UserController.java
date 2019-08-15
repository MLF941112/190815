package cn.sz.lyr.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sz.lyr.pojo.Account;
import cn.sz.lyr.pojo.Book;
import cn.sz.lyr.pojo.Users;
import cn.sz.lyr.service.IAccountService;
import cn.sz.lyr.service.IBookService;
import cn.sz.lyr.service.IUserService;
import cn.sz.lyr.util.BalanceLessException;
import cn.sz.lyr.util.StoreHouseLessException;

@Controller
@RequestMapping("/uc")
public class UserController {
	@Autowired
	private IUserService userservice;
	@Autowired
	private IAccountService accService;
	@Autowired
	private IBookService bookservice;
	
	@RequestMapping(value="login")
	public String islogin(Users u,HttpServletRequest request) {
		Users users=userservice.islogin(u);
		if (users!=null) {
			request.getSession().setAttribute("myusers",users);
			return "redirect:/bc/findall";
		}
		return "login";	
	}
	
	@RequestMapping(value="findaccount")
	public String findAccountByUser(HttpServletRequest request,Model model,Integer bookid) {
		Users u=(Users) request.getSession().getAttribute("myusers");
		//List<Account>acclist=accService.findAccByUserid(u.getUserid());
		//model.addAttribute("acclist", acclist);
		Book book=bookservice.findBookById(bookid);
		model.addAttribute("book", book);
		return "book_prebuy";	
	}
	
	@RequestMapping(value="findbalance")
	public void findBalanceByAccid(Integer accid,HttpServletResponse response) throws IOException {
		System.out.println(accid);
		Double balance= accService.findBalanceByAccid(accid);	
		PrintWriter out=response.getWriter();
		out.print(balance);
		out.flush();
		out.close();
	}
	
	@ResponseBody
	@RequestMapping(value="fa")
	public List<Account>findAccount(HttpServletRequest request){
		Users u=(Users) request.getSession().getAttribute("myusers");
		List<Account>acclist=accService.findAccByUserid(u.getUserid());
		return acclist;		
	}
	
	@RequestMapping(value="buybook")
	public String buybook(Integer bookid,Integer accid) {
		try {
			boolean flag=userservice.buybook(bookid,accid);
		} catch (StoreHouseLessException e) {
			e.printStackTrace();
		} catch (BalanceLessException e) {
			e.printStackTrace();
		}
		return "redirect:/bc/findall";
		
	}
}
