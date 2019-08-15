package cn.sz.lyr.service;

import cn.sz.lyr.pojo.Users;
import cn.sz.lyr.util.BalanceLessException;
import cn.sz.lyr.util.StoreHouseLessException;

public interface IUserService {

	public Users islogin(Users u);
	/**
	 * 
	 * ¬Ú È
	 */
	public boolean buybook(Integer bookid,Integer accid)throws StoreHouseLessException,BalanceLessException;
}
