package com.pss.service;

import java.sql.SQLException;
import java.util.List;

import com.pss.dao.IProductDao216;
import com.pss.dao.ProductDaoImpl216;
import com.pss.po.Product216;

public class ProductServiceImpl216 implements IProductService216 {
	IProductDao216 ipd = new ProductDaoImpl216();

	public ProductServiceImpl216() {

	}

	@Override
	public List<Product216> queryAll() throws SQLException {
		return ipd.queryAll();
	}

	@Override
	public void add(Product216 p) throws SQLException {
		ipd.add(p);
	}

	@Override
	public void update(Product216 p) throws SQLException {
		ipd.update(p);
	}

	@Override
	public void delete(Product216 p) throws SQLException {
		ipd.delete(p);
	}

	@Override
	public Product216 queryByID(Product216 p) throws SQLException {
		return ipd.queryByID(p);
	}

	@Override
	public List<Product216> queryByName(Product216 p) throws SQLException {
		return ipd.queryByName(p);
	}

}
