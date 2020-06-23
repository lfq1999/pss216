package com.pss.dao;

import java.sql.SQLException;
import java.util.List;

import com.pss.po.Sell216;

public interface ISellDao216 {
			// 查询所有销售单信息方法
			public List<Sell216> queryAll() throws SQLException;
			// 添加销售单的方法
			public void add(Sell216 s) throws SQLException;
			//修改销售单的方法
			public void update(Sell216 s) throws SQLException;
			// 删除销售单的方法
			public void delete(Sell216 s) throws SQLException;
			// 根据销售单编号查找商品的方法
			public Sell216 queryByID(Sell216 s) throws SQLException;
			// 根据模糊查询查找商品的方法
			public List<Sell216> queryByName(Sell216 s,int currentPage,int pageSize) throws SQLException;
			// 根据产品名称模糊查询查找商品的方法
			public List<Sell216> queryByProductName(Sell216 s,int currentPage,int pageSize) throws SQLException;
			// 根据雇员名称模糊查询查找商品的方法
			public List<Sell216> queryByEmployeeName(Sell216 s,int currentPage,int pageSize) throws SQLException;		
			//计算总的记录数的方法
			public int findTotalNum() throws SQLException;
			//分页
			public List<Sell216> findByPage(int currentPage,int pageSize) throws SQLException;
			


}
