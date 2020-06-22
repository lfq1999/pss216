package com.pss.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.pss.po.Product216;
import com.pss.util.DBUtils216;

public class ProductDaoImpl216 implements IProductDao216 {
	private QueryRunner qr = null;

	public ProductDaoImpl216() {
		qr = new QueryRunner();
	}

	@Override
	public List<Product216> queryAll() throws SQLException {
		String sql = "select * from t_product";
		List<Product216> list = qr.query(DBUtils216.getConnection(), sql,
				new BeanListHandler<Product216>(Product216.class));
		return list;
	}

	@Override
	public void add(Product216 p) throws SQLException {
		String sql = "insert into t_product (name,price,store,state) values (?,?,?,?)";
		qr.update(DBUtils216.getConnection(), sql, p.getName(), p.getPrice(), p.getStore(), p.getState());

	}

	@Override
	public void update(Product216 p) throws SQLException {
		String sql = "update t_product set name=?,price=?,store=?,state=? where pid=?";
		qr.update(DBUtils216.getConnection(), sql, p.getName(), p.getPrice(), p.getStore(), p.getState(), p.getPid());

	}

	@Override
	public void delete(Product216 p) throws SQLException {
		String sql = "delete from t_product where pid=?";
		qr.update(DBUtils216.getConnection(), sql, p.getPid());

	}

	@Override
	public Product216 queryByID(Product216 p) throws SQLException {
		String sql = "select * from t_product where pid=?";
		Product216 product = qr.query(DBUtils216.getConnection(), sql, new BeanHandler<Product216>(Product216.class),
				p.getPid());
		return product;
	}

	@Override
	public List<Product216> queryByName(Product216 p) throws SQLException {
		String sql = "select * from t_product where name like ?";
		List<Product216> list = qr.query(DBUtils216.getConnection(), sql,
				new BeanListHandler<Product216>(Product216.class), "%" + p.getName() + "%");
		return list;
	}

}
