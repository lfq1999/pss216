package com.pss.test;

import java.sql.SQLException;
import java.util.List;

import com.pss.po.Employee216;
import com.pss.service.EmployeeServiceImpl216;
import com.pss.service.IEmployeeService216;

public class TestEmployeeServiceImpl216 {

	public TestEmployeeServiceImpl216() {

	}
	public static void main(String[] args) throws SQLException {
		IEmployeeService216 ies = new EmployeeServiceImpl216();
		//查询所有雇员信息
		List<Employee216> list = ies.queryAll();
		for(Employee216 e:list) {
			System.out.println(e);
		}
		
		//添加雇员信息
		
//		ies.add(new Employee216(0,"潇寒","男","1999-02-23","17563214597",1));
		
		//修改雇员信息
//		ies.update(new Employee216(8,"小小","女","1999-03-25","11111111111",1));
		//删除雇员信息
//		ies.delete(new Employee216(8,"小小","女","1999-03-25","11111111111",1));
		
		//根据雇员ID查询
		
//		Employee216 employee = ies.queryByID(new Employee216(5,"潇寒","男","1999-02-23","17563214597",1));
//		System.out.println(employee);
		
		
		//根据雇员姓名模糊查询
//		List<Employee216> list = ies.queryByName(new Employee216(0,"刚","男","1999-02-23","17563214597",1));
//		for(Employee216 e:list) {
//			System.out.println(e);
//		}
	}

}
