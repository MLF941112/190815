package cn.sz.lyr.service;

import java.util.List;

import cn.sz.lyr.pojo.Account;

public interface IAccountService {

	public List<Account>findAccByUserid(Integer userid);
	
	public Double findBalanceByAccid(Integer userid);
}
