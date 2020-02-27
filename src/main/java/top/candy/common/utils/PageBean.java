package top.candy.common.utils;

import java.util.List;

public class PageBean<T> {

	//后台要在页面上显示的数据
	//总页数是由总记录数计算出来的
	private int totalCount;//总记录数
	private int currentPage;//当前页面
	private int pageSize;//页面总数
    private List<T> list;//当前页面展示的数据
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
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
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
    
}
