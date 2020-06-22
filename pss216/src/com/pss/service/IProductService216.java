package com.pss.service;

import java.sql.SQLException;
import java.util.List;

import com.pss.po.Product216;

public interface IProductService216 {
	// 查询所有商品信息方法
	public List<Product216> queryAll() throws SQLException;

	// 添加商品的方法
	public void add(Product216 p) throws SQLException;

	// 修改商品的方法
	public void update(Product216 p) throws SQLException;

	// 删除商品的方法
	public void delete(Product216 p) throws SQLException;

	// 根据商品编号查找商品的方法
	public Product216 queryByID(Product216 p) throws SQLException;

	// 根据商品名称查找商品的方法
	public List<Product216> queryByName(Product216 p) throws SQLException;
}
