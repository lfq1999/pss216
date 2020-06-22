package com.pss.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.pss.po.Employee216;
import com.pss.util.DBUtils216;

public class EmployeeDaoImpl216 implements IEmployeeDao216 {
	private QueryRunner qr = null;
	public EmployeeDaoImpl216() {
		qr = new QueryRunner();
	}

	@Override
	public List<Employee216> queryAll() throws SQLException {
		String sql = "select * from t_employee";
		List<Employee216> list = qr.query(DBUtils216.getConnection(), sql,
				new BeanListHandler<Employee216>(Employee216.class));
		return list;
	}

	@Override
	public void add(Employee216 e) throws SQLException {
		String sql = "insert into t_employee (name,sex,birthday,phone,state) values (?,?,?,?,?)";
		qr.update(DBUtils216.getConnection(), sql, e.getName(),e.getSex(),e.getBirthday(),e.getPhone(),e.getState());
	}

	@Override
	public void update(Employee216 e) throws SQLException {
		String sql = "update t_employee set name=?,sex=?,birthday=?,phone=?,state=? where eid=?";
		qr.update(DBUtils216.getConnection(), sql, e.getName(),e.getSex(),e.getBirthday(),e.getPhone(),e.getState(),e.getEid());
	}

	@Override
	public void delete(Employee216 e) throws SQLException {
		String sql = "delete from t_employee where eid=?";
		qr.update(DBUtils216.getConnection(), sql, e.getEid());
		
	}

	@Override
	public Employee216 queryByID(Employee216 e) throws SQLException {
		String sql = "select * from t_employee where eid=?";
		Employee216 employee = qr.query(DBUtils216.getConnection(), sql, new BeanHandler<Employee216>(Employee216.class),
				e.getEid());
		return employee;
	}

	@Override
	public List<Employee216> queryByName(Employee216 e,int currentPage,int pageSize) throws SQLException {
		String sql = "select * from t_employee where name like ? or sex like ? or phone like ? limit ?,?";
		List<Employee216> list = qr.query(DBUtils216.getConnection(), sql,
				new BeanListHandler<Employee216>(Employee216.class), "%" + e.getName() + "%","%" + e.getSex() + "%","%" + e.getPhone() + "%",(currentPage-1)*pageSize,pageSize);
		return list;
	}

	@Override
	public int findTotalNum() throws SQLException {
		String sql = "select count(eid) from t_employee";
		Object obj = qr.query(DBUtils216.getConnection(), sql,new ScalarHandler<Object>());
		return Integer.parseInt(String.valueOf(obj));
	}

	@Override
	public List<Employee216> findByPage(int currentPage, int pageSize) throws SQLException {
		String sql = "select * from t_employee limit ?,?";
		List<Employee216> list = qr.query(DBUtils216.getConnection(), sql,new BeanListHandler<Employee216>(Employee216.class),(currentPage-1)*pageSize,pageSize);
		return list;
	}

}
