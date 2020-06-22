package com.pss.po;

import java.io.Serializable;

/**
 * 商品实体类
 * 
 * @author LFQ
 *
 */

public class Product216 implements Serializable {
	private static final long serialVersionUID = 1L;
	private int pid;// 商品编号
	private String name;// 商品名称
	private float price;// 商品价格
	private int store;// 商品储量
	private int state;// 商品状态

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStore() {
		return store;
	}

	public void setStore(int store) {
		this.store = store;
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pid;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + state;
		result = prime * result + store;
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
		Product216 other = (Product216) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pid != other.pid)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (state != other.state)
			return false;
		if (store != other.store)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "product216 [pid=" + pid + ", name=" + name + ", price=" + price + ", store=" + store + ", state="
				+ state + "]";
	}

	public Product216(int pid, String name, float price, int store, int state) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.store = store;
		this.state = state;
	}

	public Product216() {
		super();
	}

}
