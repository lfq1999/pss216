package com.pss.test;

import java.sql.SQLException;
import java.util.List;

import com.pss.dao.IProductDao216;
import com.pss.dao.ProductDaoImpl216;
import com.pss.po.Product216;

public class TestProductDaoImpl216 {

	public TestProductDaoImpl216() {

	}

	public static void main(String[] args) throws SQLException {
		IProductDao216 pd = new ProductDaoImpl216();
//		List<Product216> list = pd.queryAll();//查询所有商品方法
//		for(Product216 p:list) {
//			System.out.println(p);
//		}
//		
		List<Product216> list1 = pd.queryByName(new Product216(4, "小米", 3299, 1024, 1));
		for (Product216 p : list1) {
			System.out.println(p);
		}
		// pd.update(new Product216(4,"黑鲨游戏手机2Pro",3299,1024,1));

		// pd.delete(new Product216(4,"黑鲨游戏手机2Pro",3299,1024,1));

		// pd.add(new Product216(0,"黑鲨游戏手机2Pro",3199,100,1));//添加商品信息

	}

}
