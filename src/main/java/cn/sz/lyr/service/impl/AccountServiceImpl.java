package cn.sz.lyr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.lyr.dao.IAccountDAO;
import cn.sz.lyr.pojo.Account;
import cn.sz.lyr.service.IAccountService;
@Service
public class AccountServiceImpl implements IAccountService {
	@Autowired
	private IAccountDAO accountdao;

	public List<Account> findAccByUserid(Integer userid) {
		if (userid==null) {
			return null;
		}
		
		return accountdao.findAccByUserid(userid);
	}

	public Double findBalanceByAccid(Integer userid) {
		
		return accountdao.findBalanceByAccid(userid);
	}

}
