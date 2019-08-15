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
		//���������һ
		int count=userdao.findCountByBookid(bookid);
		if (count<=0) {
			throw new StoreHouseLessException("�����������");
		}
		userdao.countplusone(bookid);
		//������
		Double balance=accdao.findBalanceByAccid(accid);//�˻��������
		Double price=bookdao.findPriceByBookid(bookid);//�鼮�۸�
		Map<String, Object>map=new HashMap<String, Object>();
		if (balance-price<=0) {
			throw new BalanceLessException("�˻�����");
		}
		Double newmoney=balance-price;
		map.put("newmoney", newmoney);
		map.put("accid", accid);
		accdao.changeBalance(map);
		return true;
	}

}
