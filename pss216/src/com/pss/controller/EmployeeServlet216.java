package com.pss.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pss.po.Employee216;
import com.pss.service.EmployeeServiceImpl216;
import com.pss.service.IEmployeeService216;
import com.pss.util.PageUtils216;


@WebServlet(urlPatterns ="/employeeServlet",name="EmployeeServlet216") 
public class EmployeeServlet216 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     IEmployeeService216 ies =new EmployeeServiceImpl216();

    public EmployeeServlet216() {
        super();
    }
    
    protected void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int currentPage = 1;
    	int pageSize = 10;
    	try {
    		String curPage = request.getParameter("currentPage");
    		if(null!=curPage) {
    			currentPage = Integer.parseInt(curPage);
    		}
    		String pageSizes = request.getParameter("pageSize");
    		if(null!=pageSizes) {
    			pageSize = Integer.parseInt(pageSizes);
    		}
    	System.out.println("当前第"+currentPage+"页，每页"+pageSize+"条");
    	}catch(Exception e){
    	}
    	
    	try {
    		int totalNum = ies.findTotalNum();
    		PageUtils216<Employee216> pu = new PageUtils216<Employee216>(currentPage, pageSize, totalNum);
    		List<Employee216> list = ies.findByPage(pu.getCurrentPage(), pu.getPageSize());
    		pu.setList(list);
    		request.setAttribute("pageBean", pu);
    		request.getRequestDispatcher("employeelist.jsp").forward(request, response);
    		
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    	}
    
    
    protected void queryByKeyWords(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int currentPage = 1;
    	int pageSize = 10;
    	String keyWords="";
    	try {
    		keyWords = request.getParameter("kw");
    	String curPage = request.getParameter("currentPage");
    	if(null!=curPage) {
    		currentPage = Integer.parseInt(curPage);
    	}
    	String pageSizes = request.getParameter("pageSize");
    	if(null!=pageSizes) {
    		pageSize = Integer.parseInt(pageSizes);
    	}
    	
    	}catch(Exception e){
    	}
    	
    	try {
    		int totalNum = ies.findTotalNum();
    		PageUtils216<Employee216> pu = new PageUtils216<Employee216>(currentPage, pageSize, totalNum);
    		Employee216 emp = new Employee216();
    		emp.setName(keyWords);
    		emp.setSex(keyWords);
    		emp.setPhone(keyWords);
    		List<Employee216> list = ies.queryByName(emp,pu.getCurrentPage(), pu.getPageSize());
    		pu.setList(list);
    		request.setAttribute("pageBean", pu);
    		request.getRequestDispatcher("employeelist.jsp").forward(request, response);
    		
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    	}
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  //查询显示所有雇员信息
        String action = request.getParameter("action");
        if("add".equals(action)) {
        	add(request, response);
        }else if("update".equals(action)) {
        	update(request, response);
        }else if("delete".equals(action)) {
        	delete(request, response);
        }else if("queryAll".equals(action)) {
        	queryAll(request, response);
        }else if("queryByID".equals(action)) {
        	queryByID(request, response);
        }else if("findByPage".equals(action)) {
        	findByPage(request,response);
        }else if("queryByKeyWords".equals(action)) {
        	queryByKeyWords(request,response);
        }else if("deleteAll".equals(action)) {
			deleteAll(request,response);
        }
        
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		Employee216 e = new Employee216(0,name,sex,birthday,phone,1);
		try {
			ies.add(e);
			findByPage(request,response);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid = request.getParameter("eid");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		Employee216 e = new Employee216(Integer.parseInt(eid),name,sex,birthday,phone,1);
		try {
			ies.update(e);
			findByPage(request,response);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid = request.getParameter("eid");
		Employee216 emp = new Employee216();
		emp.setEid(Integer.parseInt(eid));
		try {
			ies.delete(emp);
			findByPage(request,response);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	
	private void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkId = request.getParameter("checkId");
		String[] str = checkId.split(",");
		int[] ids = new int[str.length-1];
		if(str.length-1>0) {
			for(int i =0;i<str.length-1;i++) {
				ids[i]=Integer.parseInt(str[i+1]);
			}
		}
		Employee216 emp = new Employee216();
		for(int id:ids) {
			emp.setEid(id);
			try {
				ies.delete(emp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		findByPage(request, response);
	
	}
	
	
	private void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Employee216> elist = ies.queryAll();
			request.setAttribute("list", elist);
			request.getRequestDispatcher("employeelist.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void queryByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid = request.getParameter("eid");
		Employee216 e = new Employee216();
		e.setEid(Integer.parseInt(eid));
		try {
			Employee216 emp = ies.queryByID(e);
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("updateEmployee.jsp").forward(request, response);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}



}
