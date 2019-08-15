package cn.sz.lyr.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.sz.lyr.dao.IAccountDAO;
import cn.sz.lyr.dao.IBookDAO;
import cn.sz.lyr.dao.IUserDAO;
import cn.sz.lyr.pojo.Users;
import cn.sz.lyr.service.IUserService;
import cn.sz.lyr.util.BalanceLessException;
import cn.sz.lyr.util.StoreHouseLessException;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDAO userdao;
	@Autowired
	private IAccountDAO accdao;
	@Autowired
	private IBookDAO bookdao;
	
	public Users islogin(Users u) {
		
		return userdao.findUserByNameAndPwd(u);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,rollbackFor= {StoreHouseLessException.class,BalanceLessException.class},readOnly=false,timeout=2000)
	public boolean buybook(Integer bookid,Integer accid) throws StoreHouseLessException, BalanceLessException {
		//库存数量减一
		int count=userdao.findCountByBookid(bookid);
		if (count<=0) {
			throw new StoreHouseLessException("库存数量不足");
		}
		userdao.countplusone(bookid);
		//余额减少
		Double balance=accdao.findBalanceByAccid(accid);//账户现有余额
		Double price=bookdao.findPriceByBookid(bookid);//书籍价格
		Map<String, Object>map=new HashMap<String, Object>();
		if (balance-price<=0) {
			throw new BalanceLessException("账户余额不足");
		}
		Double newmoney=balance-price;
		map.put("newmoney", newmoney);
		map.put("accid", accid);
		accdao.changeBalance(map);
		return true;
	}

}
