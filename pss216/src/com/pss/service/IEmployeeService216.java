package com.pss.service;

import java.sql.SQLException;
import java.util.List;

import com.pss.po.Employee216;

public interface IEmployeeService216 {
	// 查询所有雇员信息方法
	public List<Employee216> queryAll() throws SQLException;

	// 添加雇员的方法
	public void add(Employee216 e) throws SQLException;

	// 修改雇员的方法
	public void update(Employee216 e) throws SQLException;

	// 删除雇员的方法
	public void delete(Employee216 e) throws SQLException;

	// 根据雇员编号查找商品的方法
	public Employee216 queryByID(Employee216 e) throws SQLException;

	// 根据雇员名称查找商品的方法
	public List<Employee216> queryByName(Employee216 e) throws SQLException;
	//计算总的记录数的方法
	public int findTotalNum() throws SQLException;
	
	//分页
	public List<Employee216> findByPage(int currentPage,int pageSize) throws SQLException;
	

}
