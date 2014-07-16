package org.orange.wechatcontainer.common;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
/**
 * page request
 * <T> was filters type
 * 
 */
public class PageRequest<T> implements Serializable {

	/**
	 * filters
	 */
	@Deprecated
	private T filters;
	/**
	 * page start from 1
	 */
	private int pageNumber;
	/**
	 * 
	 */
	private int pageSize;
	/**
	 * sort columns: username desc
	 */
	private String sortColumns;
	
	public PageRequest() {
		this(0,0);
	}
	
	@Deprecated
	public PageRequest(T filters) {
		this(0,0,filters);
	}
	
	public PageRequest(int pageNumber, int pageSize) {
		this(pageNumber,pageSize,(T)null);
	}
	
	@Deprecated
	public PageRequest(int pageNumber, int pageSize, T filters) {
		this(pageNumber,pageSize,filters,null);
	}
	
	public PageRequest(int pageNumber, int pageSize,String sortColumns) {
		this(pageNumber,pageSize,null,sortColumns);
	}
	
	@Deprecated
	public PageRequest(int pageNumber, int pageSize, T filters,String sortColumns) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		setFilters(filters);
		setSortColumns(sortColumns);
	}
	
	@Deprecated
	public T getFilters() {
		return filters;
	}

	@Deprecated
	public void setFilters(T filters) {
		this.filters = filters;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getSortColumns() {
		return sortColumns;
	}
	/**
	 *  username desc,age asc
	 * @return
	 */
	public void setSortColumns(String sortColumns) {
		checkSortColumnsSqlInjection(sortColumns);
		if(sortColumns != null && sortColumns.length() > 50) {
			throw new IllegalArgumentException("sortColumns.length() <= 50 must be true");
		}
		this.sortColumns = sortColumns;
	}

	/**
	 * 
	 * @return SortInfo list
	 */
	public List<SortInfo> getSortInfos() {
		return Collections.unmodifiableList(SortInfo.parseSortColumns(sortColumns));
	}
	
	private void checkSortColumnsSqlInjection(String sortColumns) {
		if(sortColumns == null) return;
		if(sortColumns.indexOf("'") >= 0 || sortColumns.indexOf("\\") >= 0) {
			throw new IllegalArgumentException("sortColumns:"+sortColumns+" has SQL Injection risk");
		}
	}
}
