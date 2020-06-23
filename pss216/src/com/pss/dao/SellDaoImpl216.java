package com.pss.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.pss.po.Sell216;
import com.pss.util.DBUtils216;

public class SellDaoImpl216 implements ISellDao216 {
	private QueryRunner qr = null;
	public SellDaoImpl216() {
		qr = new QueryRunner();
	}

	@Override
	public List<Sell216> queryAll() throws SQLException {
		String sql = "select * from t_sell";
		List<Sell216> list = qr.query(DBUtils216.getConnection(), sql,
				new BeanListHandler<Sell216>(Sell216.class));
		return list;
	}

	@Override
	public void add(Sell216 s) throws SQLException {
		String sql = "insert into t_sell (sid,pid,eid,amount,selldate,state) values (?,?,?,?,?,?)";
		qr.update(DBUtils216.getConnection(), sql, s.getSid(),s.getPid(),s.getEid(),s.getAmount(),s.getSelldate(),s.getState());
		
	}

	@Override
	public void update(Sell216 s) throws SQLException {
		String sql = "update t_sell set pid=?,eid=?,amount=?,selldate=?,state=? where sid=?";
		qr.update(DBUtils216.getConnection(), sql, s.getPid(),s.getEid(),s.getAmount(),s.getSelldate(),s.getState(),s.getSid());
		
	}

	@Override
	public void delete(Sell216 s) throws SQLException {
		String sql = "delete from t_sell where sid=?";
		qr.update(DBUtils216.getConnection(), sql, s.getSid());
		
	}

	@Override
	public Sell216 queryByID(Sell216 s) throws SQLException {
		String sql = "select * from t_sell where sid=?";
		Sell216 sell = qr.query(DBUtils216.getConnection(), sql, new BeanHandler<Sell216>(Sell216.class),
				s.getSid());
		return sell;
	}

	@Override
	public List<Sell216> queryByName(Sell216 s,int currentPage,int pageSize) throws SQLException {
		String sql = "select * from t_sell where sid like ? limit ?,?";
		List<Sell216> list = qr.query(DBUtils216.getConnection(), sql,
				new BeanListHandler<Sell216>(Sell216.class), "%" + s.getSid() + "%",(currentPage-1)*pageSize,pageSize);
		return list;
	}

	@Override
	public int findTotalNum() throws SQLException {
		String sql = "select count(sid) from t_sell";
		Object obj = qr.query(DBUtils216.getConnection(), sql,new ScalarHandler<Object>());
		return Integer.parseInt(String.valueOf(obj));
	}

	@Override
	public List<Sell216> findByPage(int currentPage, int pageSize) throws SQLException {
		String sql = "select * from t_sell limit ?,?";
		List<Sell216> list = qr.query(DBUtils216.getConnection(), sql,new BeanListHandler<Sell216>(Sell216.class),(currentPage-1)*pageSize,pageSize);
		return list;
	}

	@Override
	public List<Sell216> queryByProductName(Sell216 s,int currentPage,int pageSize) throws SQLException {
		String sql = "select * from t_sell where pid like ? limit ?,?";
		List<Sell216> list = qr.query(DBUtils216.getConnection(), sql,
				new BeanListHandler<Sell216>(Sell216.class), "%" + s.getPid() + "%",(currentPage-1)*pageSize,pageSize);
		return list;
	}

	@Override
	public List<Sell216> queryByEmployeeName(Sell216 s,int currentPage,int pageSize) throws SQLException {
		String sql = "select * from t_sell where eid like ? limit ?,?";
		List<Sell216> list = qr.query(DBUtils216.getConnection(), sql,
				new BeanListHandler<Sell216>(Sell216.class), "%" + s.getEid() + "%",(currentPage-1)*pageSize,pageSize);
		return list;
	}


}
