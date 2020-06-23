package com.pss.test;

import java.sql.SQLException;
import java.util.List;

import com.pss.po.Product216;
import com.pss.service.IProductService216;
import com.pss.service.ProductServiceImpl216;

public class TestProductServiceImpl216 {

	public TestProductServiceImpl216() {
		
	}
	public static void main(String[] args) throws SQLException {
		IProductService216 ips = new ProductServiceImpl216();
		//添加方法
		//ips.add(new Product216(0,"华为P30Pro",5020,120,1));
		
		//更新方法
		//ips.update(new Product216(5,"华为P30",5000,110,1));
		
		//删除方法
		//ips.delete(new Product216(5,"华为P30",5000,110,1));
		
		//根据ID查询
//		Product216 product = ips.queryByID(new Product216(2,"",0,0,1));
//		System.out.println(product);
		
		//根据名称模糊查询
		List<Product216> list1 = ips.queryByName(new Product216(0,"米",0,0,1),1,10);
		for(Product216 p:list1) {
			System.out.println(p);
		}
		
		
		
		//查询所有
//		List<Product216> list = ips.queryAll();//查询所有商品方法
//		for(Product216 p:list) {
//			System.out.println(p);
//		}
	}
}
