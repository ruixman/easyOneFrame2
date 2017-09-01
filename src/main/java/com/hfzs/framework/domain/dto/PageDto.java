package com.hfzs.framework.domain.dto;

import java.util.Map;

/**
 * jquery.datatable 分页数据封装类
 * @author wei
 *
 */
public class PageDto<T> {
	
	private Integer limit=10;//每页条数
	private Integer start=0;//开始的记录序号
	private Integer page=0;//当前页
	private Integer total;//总数

	//private Object searchObj;

	private Map<String,String[]> searchMap;

//	private String extendParam;
//	private List<T> data;
//	private Sort sort;


	public Map<String, String[]> getSearchMap() {
		return searchMap;
	}

	public void setSearchMap(Map<String, String[]> searchMap) {
		this.searchMap = searchMap;
	}

	private String sort="id";
	private String asc="desc";

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getAsc() {
		return asc;
	}

	public void setAsc(String asc) {
		this.asc = asc;
	}

	public Integer getLimit() {
		return limit;
	}
	
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	public Integer getStart() {
		return start;
	}
	
	public void setStart(Integer start) {
		this.start = start;
	}
	
	public Integer getPage() {
		return page;
	}
	
	public void setPage(Integer page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "Page [limit=" + limit + ", start=" + start + ", page=" + page + ", data="+ "]";
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
