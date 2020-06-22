package com.pss.test;

import java.sql.SQLException;
import java.util.List;

import com.pss.dao.ISellDao216;
import com.pss.dao.SellDaoImpl216;
import com.pss.po.Sell216;

public class TestSellDaoImpl216 {

	public TestSellDaoImpl216() {

	}
	public static void main(String[] args) throws SQLException {
		ISellDao216 isd = new SellDaoImpl216();
		//查询所有销售单信息
//		List<Sell216> list = isd.queryAll();
//		for(Sell216 s:list) {
//			System.out.println(s);
//		}
		//添加销售的信息
//		isd.add(new Sell216("202006171134",1,2,3,"2020-06-17",1));
//		isd.add(new Sell216("20200617113430",2,5,6,"2020-06-17",1));
		
		//修改销售信息
//		isd.update(new Sell216("20200617113430",2,5,6,"2020-06-17",1));
		
		//删除销售信息
//		isd.delete(new Sell216("202006171134",1,2,3,"2020-06-17",1));
		
		//根据销售单号查询
//		Sell216 sell = isd.queryByID(new Sell216("20200617113430",1,2,3,"2020-06-17",1));
//		System.out.println(sell);
		
		//
		
		
	}
}
