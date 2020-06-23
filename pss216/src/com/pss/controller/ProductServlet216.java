package com.pss.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pss.po.Product216;
import com.pss.service.IProductService216;
import com.pss.service.ProductServiceImpl216;
import com.pss.util.PageUtils216;


@WebServlet(urlPatterns ="/productServlet",name="ProductServlet216") 
public class ProductServlet216 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     IProductService216 ips =new ProductServiceImpl216();

    public ProductServlet216() {
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
    		int totalNum = ips.findTotalNum();
    		PageUtils216<Product216> pu = new PageUtils216<Product216>(currentPage, pageSize, totalNum);
    		List<Product216> list = ips.findByPage(pu.getCurrentPage(), pu.getPageSize());
    		pu.setList(list);
    		request.setAttribute("pageBean", pu);
    		request.getRequestDispatcher("productlist.jsp").forward(request, response);
    		
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
    		int totalNum = ips.findTotalNum();
    		PageUtils216<Product216> pu = new PageUtils216<Product216>(currentPage, pageSize, totalNum);
    		Product216 pro = new Product216();
    		
    		System.out.println(keyWords);
    		pro.setName(keyWords);
    		List<Product216> list = ips.queryByName(pro,pu.getCurrentPage(), pu.getPageSize());
    		pu.setList(list);
    		request.setAttribute("pageBean", pu);
    		request.getRequestDispatcher("productlist.jsp").forward(request, response);
    		
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
		String price = request.getParameter("price");
		String store = request.getParameter("store");
		Product216 pro = new Product216(0,name,Float.parseFloat(price),Integer.parseInt(store),1);
		try {
			ips.add(pro);
			findByPage(request,response);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String store = request.getParameter("store");
		Product216 pro = new Product216(Integer.parseInt(pid),name,Float.parseFloat(price),Integer.parseInt(store),1);
		try {
			ips.update(pro);
			findByPage(request,response);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		Product216 pro = new Product216();
		pro.setPid(Integer.parseInt(pid));
		try {
			ips.delete(pro);
			findByPage(request,response);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	
	private void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkId = request.getParameter("checkId");
		String[] str = checkId.split(",");
		int[] ids = new int[str.length];
		if(str.length>0) {
			for(int i =0;i<str.length;i++) {
				ids[i]=Integer.parseInt(str[i]);
			}
		}
		Product216 pro = new Product216();
		for(int id:ids) {
			pro.setPid(id);
			try {
				ips.delete(pro);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		findByPage(request, response);
	
	}
	
	
	private void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Product216> plist = ips.queryAll();
			request.setAttribute("list", plist);
			request.getRequestDispatcher("productlist.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void queryByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		Product216 p = new Product216();
		p.setPid(Integer.parseInt(pid));
		try {
			Product216 pro = ips.queryByID(p);
			request.setAttribute("pro", pro);
			request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}



}
