package com.pss.po;

import java.io.Serializable;

/**
 * 销售单实体类
 * 
 * @author LFQ
 *
 */

public class Sell216 implements Serializable {
	private static final long serialVersionUID = 1L;
	private String sid;// 销售编号
	private int pid;// 产品编号
	private int eid;// 雇员编号
	private int amount;// 数量
	private String selldate;// 销售日期
	private int state;// 状态

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSelldate() {
		return selldate;
	}

	public void setSelldate(String selldate) {
		this.selldate = selldate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + eid;
		result = prime * result + pid;
		result = prime * result + ((selldate == null) ? 0 : selldate.hashCode());
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		result = prime * result + state;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sell216 other = (Sell216) obj;
		if (amount != other.amount)
			return false;
		if (eid != other.eid)
			return false;
		if (pid != other.pid)
			return false;
		if (selldate == null) {
			if (other.selldate != null)
				return false;
		} else if (!selldate.equals(other.selldate))
			return false;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		if (state != other.state)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "sell216 [sid=" + sid + ", pid=" + pid + ", eid=" + eid + ", amount=" + amount + ", selldate=" + selldate
				+ ", state=" + state + "]";
	}

	public Sell216(String sid, int pid, int eid, int amount, String selldate, int state) {
		super();
		this.sid = sid;
		this.pid = pid;
		this.eid = eid;
		this.amount = amount;
		this.selldate = selldate;
		this.state = state;
	}

	public Sell216() {
		super();
	}

}
