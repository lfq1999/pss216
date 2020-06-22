package com.pss.service;

import java.sql.SQLException;
import java.util.List;

import com.pss.dao.EmployeeDaoImpl216;
import com.pss.dao.IEmployeeDao216;
import com.pss.po.Employee216;

public class EmployeeServiceImpl216 implements IEmployeeService216 {
IEmployeeDao216 ied = new EmployeeDaoImpl216();
	public EmployeeServiceImpl216() {

	}

	@Override
	public List<Employee216> queryAll() throws SQLException {
		return ied.queryAll();
	}

	@Override
	public void add(Employee216 e) throws SQLException {

		ied.add(e);
	}

	@Override
	public void update(Employee216 e) throws SQLException {

		ied.update(e);
	}

	@Override
	public void delete(Employee216 e) throws SQLException {

		ied.delete(e);
	}

	@Override
	public Employee216 queryByID(Employee216 e) throws SQLException {
		return ied.queryByID(e);
	}

	@Override
	public List<Employee216> queryByName(Employee216 e) throws SQLException {
		return ied.queryByName(e);
	}

	@Override
	public int findTotalNum() throws SQLException {

		return ied.findTotalNum();
	}

	@Override
	public List<Employee216> findByPage(int currentPage, int pageSize) throws SQLException {

		return ied.findByPage(currentPage, pageSize);
	}

}
