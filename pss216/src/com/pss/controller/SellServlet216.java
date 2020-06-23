//package com.pss.controller;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.junit.Assert;
//
//import com.pss.dao.EmployeeDaoImpl216;
//import com.pss.dao.IEmployeeDao216;
//import com.pss.dao.IProductDao216;
//import com.pss.dao.ISellDao216;
//import com.pss.dao.ProductDaoImpl216;
//import com.pss.dao.SellDaoImpl216;
//import com.pss.po.Employee216;
//import com.pss.po.Product216;
//import com.pss.po.Sell216;
//import com.pss.service.EmployeeServiceImpl216;
//import com.pss.service.IEmployeeService216;
//import com.pss.service.IProductService216;
//import com.pss.service.ISellService216;
//import com.pss.service.ProductServiceImpl216;
//import com.pss.service.SellServiceImpl216;
//import com.pss.util.PageUtils216;
//
//
//@WebServlet(urlPatterns ="/sellServlet216",name="SellServlet216216") 
//public class SellServlet216 extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	IProductService216 ips = new ProductServiceImpl216();
//	IEmployeeService216 ies = new EmployeeServiceImpl216();
//	ISellService216 iss = new SellServiceImpl216();
//
//    public SellServlet216() {
//        super();
//    }
//    
//    protected void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	int currentPage = 1;
//    	int pageSize = 10;
//    	try {
//    		String curPage = request.getParameter("currentPage");
//    		if(null!=curPage) {
//    			currentPage = Integer.parseInt(curPage);
//    		}
//    		String pageSizes = request.getParameter("pageSize");
//    		if(null!=pageSizes) {
//    			pageSize = Integer.parseInt(pageSizes);
//    		}
//    	System.out.println("当前第"+currentPage+"页，每页"+pageSize+"条");
//    	}catch(Exception e){
//    	}
//    	
//    	try {
//    		int totalNum = iss.findTotalNum();
//    		PageUtils216<Sell216> pu = new PageUtils216<Sell216>(currentPage, pageSize, totalNum);
//    		List<Sell216> list = iss.findByPage(pu.getCurrentPage(), pu.getPageSize());
//    		pu.setList(list);
//    		request.setAttribute("pageBean", pu);
//    		request.getRequestDispatcher("productlist.jsp").forward(request, response);
//    		
//    	}catch (Exception e) {
//    		e.printStackTrace();
//		}
//    	}
//    
//    
//    protected void queryByKeyWords(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	int currentPage = 1;
//    	int pageSize = 10;
//    	String keyWords="";
//    	try {
//    		keyWords = request.getParameter("kw");
//    	String curPage = request.getParameter("currentPage");
//    	if(null!=curPage) {
//    		currentPage = Integer.parseInt(curPage);
//    	}
//    	String pageSizes = request.getParameter("pageSize");
//    	if(null!=pageSizes) {
//    		pageSize = Integer.parseInt(pageSizes);
//    	}
//    	
//    	}catch(Exception e){
//    	}
//    	
//    	try {
//    		int totalNum = iss.findTotalNum();
//    		PageUtils216<Sell216> spu = new PageUtils216<Sell216>(currentPage, pageSize, totalNum);
//    		PageUtils216<Employee216> epu = new PageUtils216<Employee216>(currentPage, pageSize, totalNum);
//    		PageUtils216<Product216> ppu = new PageUtils216<Product216>(currentPage, pageSize, totalNum);
//    		Sell216 sell = new Sell216();
//    		Product216 pro = new Product216();
//    		Employee216 emp = new Employee216();
//    		pro.setName(keyWords);
//    		emp.setName(keyWords);
//    		
//    		
//
//    		List<Product216> plist = ips.queryByName(pro,ppu.getCurrentPage(), pu.getPageSize());
//    		List<Employee216> elist = ies.queryByName(emp,epu.getCurrentPage(), pu.getPageSize());
//    		pu.setList(plist);
//    		pu.setList(elist);
//    		request.setAttribute("pageBean", pu);
//    		request.getRequestDispatcher("productlist.jsp").forward(request, response);
//    		
//    	}catch (Exception e) {
//    		e.printStackTrace();
//		}
//    	}
//    
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		  //查询显示所有雇员信息
//        String action = request.getParameter("action");
//        if("add".equals(action)) {
//        	add(request, response);
//        }else if("update".equals(action)) {
//        	update(request, response);
//        }else if("delete".equals(action)) {
//        	delete(request, response);
//        }else if("queryAll".equals(action)) {
//        	queryAll(request, response);
//        }else if("queryByID".equals(action)) {
//        	queryByID(request, response);
//        }else if("findByPage".equals(action)) {
//        	findByPage(request,response);
//        }else if("queryByKeyWords".equals(action)) {
////        	queryByKeyWords(request,response);
//        }else if("deleteAll".equals(action)) {
//			deleteAll(request,response);
//        }
//        
//	}
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//	
//	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name = request.getParameter("name");
//		String price = request.getParameter("price");
//		String store = request.getParameter("store");
//		Product216 pro = new Product216(0,name,Float.parseFloat(price),Integer.parseInt(store),1);
//		try {
//			iss.add(pro);
//			findByPage(request,response);
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//	}
//	
//	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String pid = request.getParameter("pid");
//		String name = request.getParameter("name");
//		String price = request.getParameter("price");
//		String store = request.getParameter("store");
//		Product216 pro = new Product216(Integer.parseInt(pid),name,Float.parseFloat(price),Integer.parseInt(store),1);
//		try {
//			iss.update(pro);
//			findByPage(request,response);
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//	}
//	
//	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String pid = request.getParameter("pid");
//		Product216 pro = new Product216();
//		pro.setPid(Integer.parseInt(pid));
//		try {
//			iss.delete(pro);
//			findByPage(request,response);
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//	}
//	
//	
//	private void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String checkId = request.getParameter("checkId");
//		String[] str = checkId.split(",");
//		int[] ids = new int[str.length-1];
//		if(str.length-1>0) {
//			for(int i =0;i<str.length-1;i++) {
//				ids[i]=Integer.parseInt(str[i+1]);
//			}
//		}
//		Product216 pro = new Product216();
//		for(int id:ids) {
//			pro.setPid(id);
//			try {
//				iss.delete(pro);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		findByPage(request, response);
//	
//	}
//	
//	
//	private void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		try {
//			List<Product216> plist = iss.queryAll();
//			request.setAttribute("list", plist);
//			request.getRequestDispatcher("productlist.jsp").forward(request, response);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private void queryByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String pid = request.getParameter("pid");
//		Product216 p = new Product216();
//		p.setPid(Integer.parseInt(pid));
//		try {
//			Product216 pro = iss.queryByID(p);
//			request.setAttribute("pro", pro);
//			request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//	}
//
//
//
//}
