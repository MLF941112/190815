package cn.sz.lyr.dao;

import cn.sz.lyr.pojo.Users;

public interface IUserDAO {

	public Users findUserByNameAndPwd(Users u);
	/**
	 * ����1
	 * @param bookid
	 * @return 
	 */
	public Integer countplusone(Integer bookid);
	
	public Integer findCountByBookid(Integer bookid);
}
