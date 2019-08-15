package cn.sz.lyr.pojo;

import java.io.Serializable;

public class Account implements Serializable {
	private Integer accid;
	private String accName;
	private Double balance;
	private Integer userid;
	public Integer getAccid() {
		return accid;
	}
	public void setAccid(Integer accid) {
		this.accid = accid;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
}
