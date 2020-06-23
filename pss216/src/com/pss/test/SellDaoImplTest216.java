package com.pss.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.pss.dao.EmployeeDaoImpl216;
import com.pss.dao.IEmployeeDao216;
import com.pss.dao.IProductDao216;
import com.pss.dao.ISellDao216;
import com.pss.dao.ProductDaoImpl216;
import com.pss.dao.SellDaoImpl216;
import com.pss.po.Employee216;
import com.pss.po.Product216;
import com.pss.po.Sell216;
import com.pss.util.PageUtils216;


class SellDaoImplTest216 {
	ISellDao216 isd = new SellDaoImpl216();
	IEmployeeDao216 ied = new EmployeeDaoImpl216();
	IProductDao216 ipd = new ProductDaoImpl216();
	@Test
	void testQueryAll() throws SQLException {
		//查询所有销售单信息
		List<Sell216> list = isd.queryAll();
		Product216 p = new Product216();
		Employee216 e = new Employee216();
		Assert.assertEquals(6, list.size());
		for(Sell216 s:list) {
			e.setEid(s.getEid());
			p.setPid(s.getPid());
			p = ipd.queryByID(p);
			e = ied.queryByID(e);
			System.out.println("销售单号："+s.getSid()+"\t"+"销售商品名称："+p.getName()+"\t"+"销售员："+e.getName()+"\t"+"销售数量："+s.getAmount()+"\t"+"销售日期:"+s.getSelldate()+"\t");
		}
	}

	@Test
	void testAdd() throws SQLException {
		isd.add(new Sell216("20200617113430",2,5,6,"2020-06-17",1));
	}

	@Test
	void testUpdate() throws SQLException {
		isd.update(new Sell216("20200617113430",3,1,6,"2020-06-17",1));

	}

	@Test
	void testDelete() throws SQLException {
		isd.delete(new Sell216("20200617113430",1,2,3,"2020-06-17",1));
	}

	@Test
	void testQueryByID() throws SQLException {
		Sell216 sell = isd.queryByID(new Sell216("20200617113430",1,2,3,"2020-06-17",1));
		System.out.println(sell);
	}

	@Test
	void testQueryByName() throws SQLException {
		List<Sell216> list = isd.queryByName(new Sell216("2018",0,0,1,"",1),1,10);
		Assert.assertEquals(6, list.size());
		for(Sell216 s:list) {
			System.out.println(s);
		}
	}

	@Test
	void testFindTotalNum() throws SQLException {
		int totalNum = isd.findTotalNum();
		Assert.assertEquals(7, totalNum);
		System.out.println("totalNum:"+totalNum);

	}

	@Test
	void testFindByPage() throws SQLException {
//		int currentPage = 1;
//		int pageSize = 3;
//		int totalNum = isd.findTotalNum();
//		PageUtils216<Sell216> empPage = new PageUtils216<Sell216>(currentPage, pageSize, totalNum);
//		
//		empPage.setList(isd.findByPage(empPage.getCurrentPage(), empPage.getPageSize()));
//		for(Sell216 s:empPage.getList()) {
//			System.out.println(s);
//		}
		
		List<Sell216> sList = isd.findByPage(1, 3);
		for(Sell216 s:sList) {
			System.out.println(s);
		}

	}
	
	@Test
	void testQueryByProductName() throws SQLException {
		Product216 p = new Product216();
		p.setName("华");
		List<Product216> list = ipd.queryByName(p,1,10);
		Sell216 sell = new Sell216();
		for(Product216 pro:list) {
			sell.setPid(pro.getPid());
			List<Sell216> sList = isd.queryByProductName(sell,1,10);
			for(Sell216 s:sList) {
				System.out.println(s);
			}
		}
	}
	
	@Test
	void testQueryByEmployeeName() throws SQLException {
		Employee216 e = new Employee216();
		e.setName("周");
		List<Employee216> list = ied.queryByName(e,1,10);
		Sell216 sell = new Sell216();
		for(Employee216 emp:list) {
			sell.setEid(emp.getEid());
			List<Sell216> sList = isd.queryByEmployeeName(sell,1,10);
			for(Sell216 s:sList) {
				System.out.println(s);
			}
		}
	}

}
