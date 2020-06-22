package com.pss.test;

import java.sql.SQLException;
import java.util.List;

import com.pss.dao.EmployeeDaoImpl216;
import com.pss.dao.IEmployeeDao216;
import com.pss.po.Employee216;
import com.pss.util.PageUtils216;

public class TestEmployeeDaoImpl216 {

	public TestEmployeeDaoImpl216() {
	}

	public static void main(String[] args) throws SQLException {
		IEmployeeDao216 ied = new EmployeeDaoImpl216();	
		int totalNum = ied.findTotalNum();
		System.out.println("totalNum"+totalNum);
//		int currentPage = 1;
//		int pageSize = 3;
//		PageUtils216<Employee216> empPage = new PageUtils216<Employee216>(currentPage, pageSize, totalNum);
//		
//		
//		empPage.setList(ied.findByPage(empPage.getCurrentPage(), empPage.getPageSize()));
//		for(Employee216 e:empPage.getList()) {
//			System.out.println(e);
//		}
		//查询所有雇员信息
//		List<Employee216> list = ied.queryAll();
//		for(Employee216 e:list) {
//			System.out.println(e);
//		}	
		//添加雇员信息
//		ied.add(new Employee216(0,"潇寒","男","1999-02-23","17563214597",1));
		//修改雇员信息
//		ied.update(new Employee216(7,"小小","女","1999-03-25","11111111111",1));
		//删除雇员信息
//		ied.delete(new Employee216(7,"小小","女","1999-03-25","11111111111",1));
		//根据雇员ID查询
//		Employee216 employee = ied.queryByID(new Employee216(5,"潇寒","男","1999-02-23","17563214597",1));
//		System.out.println(employee);	
		//根据雇员姓名模糊查询
//		List<Employee216> list = ied.queryByName(new Employee216(0,"刚","男","1999-02-23","17563214597",1));
//		for(Employee216 e:list) {
//			System.out.println(e);
//		}
		
		//模糊查询——性别
//		List<Employee216> list = ied.queryByName(new Employee216(0,"女","女","2000-02-26","女",1));
//		for(Employee216 e:list) {
//			System.out.println(e);
//		}
		
		//模糊查询——电话
		List<Employee216> list = ied.queryByName(new Employee216(0,"15269878534","15269878534","2000-02-26","15269878534",1));
		for(Employee216 e:list) {
			System.out.println(e);
		}
	}
	//分页
	

}
