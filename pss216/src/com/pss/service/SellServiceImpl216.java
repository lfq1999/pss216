package com.pss.service;

import java.sql.SQLException;
import java.util.List;

import com.pss.dao.ISellDao216;
import com.pss.dao.SellDaoImpl216;
import com.pss.po.Sell216;

public class SellServiceImpl216 implements ISellService216 {
	ISellDao216 isd = new SellDaoImpl216();
	public SellServiceImpl216() {
	}

	@Override
	public List<Sell216> queryAll() throws SQLException {
		return isd.queryAll();
	}

	@Override
	public void add(Sell216 s) throws SQLException {
		isd.add(s);
	}

	@Override
	public void update(Sell216 s) throws SQLException {
		isd.update(s);
	}

	@Override
	public void delete(Sell216 s) throws SQLException {
		isd.delete(s);
	}

	@Override
	public Sell216 queryByID(Sell216 s) throws SQLException {
		return isd.queryByID(s);
	}

	@Override
	public List<Sell216> queryByName(Sell216 s) throws SQLException {
		return isd.queryByName(s);
	}

	@Override
	public int findTotalNum() throws SQLException {
		return isd.findTotalNum();
	}

	@Override
	public List<Sell216> findByPage(int currentPage, int pageSize) throws SQLException {
		return isd.findByPage(currentPage, pageSize);
	}

	@Override
	public List<Sell216> queryByProductName(Sell216 s) throws SQLException {
		return isd.queryByProductName(s);
	}

	@Override
	public List<Sell216> queryByEmployeeName(Sell216 s) throws SQLException {
		return isd.queryByEmployeeName(s);
	}

}
