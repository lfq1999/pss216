package com.pss.util;

import java.util.ArrayList;
import java.util.List;

public class PageUtils216<T> {

	//总记录数
	private int totalNum;
	//当前页
	private int currentPage;
	//每页显示的条数（大小）
	private int pageSize;
	//首页
	private int firstPage = 1;
	//尾页
	private int lastPage;
	//总页数=总记录数/每页显示的条数
	private int totalPage;
	//上一页
	private int prev;
	//下一页
	private int next;
	//页面序号显示的起始位置
	private int startNum;
	//页码显示控制——开始页码
	private int start;
	//页码显示控制——结束页码
	private int end;
	//显示页码控制——总显示页码（防止页码过多，页面显示拥挤难看）
	private int count = 10;
	//数据
	private List<T> list = new ArrayList<T>();
	
	public PageUtils216(int currentPage,int pageSize,int totalNum) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalNum = totalNum;
		this.totalPage = (int)Math.ceil((double)totalNum/pageSize);
		this.lastPage = (int)Math.ceil((double)totalNum/pageSize);
		this.currentPage = Math.max(this.currentPage, 1);
		this.currentPage = Math.min(this.totalPage, this.currentPage);
		this.prev = Math.max(this.currentPage - 1, 1);
		this.next = Math.min(this.currentPage + 1, this.totalPage);
		this.startNum = (this.currentPage-1)*pageSize;
		this.start = Math.max(this.currentPage-this.count/2, 1);
		this.end = Math.min(this.start+this.count, this.totalPage);
		
	}
	
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPrev() {
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
