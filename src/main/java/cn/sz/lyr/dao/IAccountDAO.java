package cn.sz.lyr.dao;

import java.util.List;
import java.util.Map;

import cn.sz.lyr.pojo.Account;

public interface IAccountDAO {

	public List<Account>findAccByUserid(Integer userid);
	
	public Double findBalanceByAccid(Integer userid);
	
	public void changeBalance(Map<String, Object>map);
}
