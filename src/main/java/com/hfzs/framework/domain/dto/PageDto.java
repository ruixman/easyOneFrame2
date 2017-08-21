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

//	public Object getSearchObj() {
//		return searchObj;
//	}
//
//	public void setSearchObj(Object searchObj) {
//		this.searchObj = searchObj;
//	}

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
	
//	public List<T> getData() {
//		return data;
//	}
//
//	public void setData(List<T> data) {
//		this.data = data;
//	}
	
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

//	public Sort getSort() {
//		return sort;
//	}
//
//	public void setSort(Sort sort) {
//		this.sort = sort;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//======datatable 控件
//	private Integer sEcho=0;//当前页(默认为0)
//	private Integer iTotalDisplayRecords;//总显示记录(总条数)
//	private Integer iDisplayLength;//每页条数
//	
//	private Integer iTotalRecords;//全记录
//	private List<T> data;
//	
////	private Map<String, Object> map;
//	
//	public Integer getiDisplayLength() {
//		return iDisplayLength;
//	}
//
//	public void setIDisplayLength(Integer iDisplayLength) {
//		this.iDisplayLength = iDisplayLength;
//	}
//
//	public Integer getiTotalDisplayRecords() {
//		return iTotalDisplayRecords;
//	}
//
//	public void setITotalDisplayRecords(Integer iTotalDisplayRecords) {
//		this.iTotalDisplayRecords = iTotalDisplayRecords;
//	}
//
//	public Integer getiTotalRecords() {
//		return iTotalRecords;
//	}
//
//	public void setITotalRecords(Integer iTotalRecords) {
//		this.iTotalRecords = iTotalRecords;
//	}
//
//	public Integer getsEcho() {
//		return sEcho;
//	}
//
//	public void setSEcho(Integer sEcho) {
//		this.sEcho = sEcho;
//	}
//
//	@Override
//	public String toString() {
//		return "Page [sEcho=" + sEcho + ", iTotalDisplayRecords="
//				+ iTotalDisplayRecords + ", iDisplayLength=" + iDisplayLength
//				+ ", iTotalRecords=" + iTotalRecords + "]";
//	}
//
//	public List<T> getData() {
//		return data;
//	}
//
//	public void setData(List<T> data) {
//		this.data = data;
//	}
//

}
