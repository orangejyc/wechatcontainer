package org.orange.wechatcontainer.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.orange.wechatcontainer.util.PageUtils;

import edu.emory.mathcs.backport.java.util.Collections;

/**
 * Page info
 * from page=1
 * @
 */
public class Page<T> implements Serializable,Iterable<T>
{
	
	protected List<T> result;

	protected int pageSize;

	protected int pageNumber;

	protected int totalCount = 0;
	
	public Page(PageRequest p, int totalCount) {
		this(p.getPageNumber(),p.getPageSize(),totalCount);
	}
	
	public Page(int pageNumber,int pageSize,int totalCount) {
		this(pageNumber,pageSize,totalCount,new ArrayList(0));
	}
	
	public Page(int pageNumber,int pageSize,int totalCount,List<T> result) {
		if(pageSize <= 0) throw new IllegalArgumentException("[pageSize] must great than zero");
		this.pageSize = pageSize;
		this.pageNumber = PageUtils.computePageNumber(pageNumber,pageSize,totalCount);
		this.totalCount = totalCount;
		setResult(result);
	}

	public void setResult(List<T> elements) {
		if(elements == null) throw new IllegalArgumentException("'result' must be not null");
		this.result = elements;
	}
	
    /**
     * current Page data
     *
     * @return 
     */
	public List<T> getResult() {
		return result;
	}
	
    /**
     * 
     *
     * @return is first page
     */
	public boolean isFirstPage() {
		return getThisPageNumber() == 1;
	}

    /**
     * 
     *
     * @return is last page?
     */
	public boolean isLastPage() {
		return getThisPageNumber() >= getLastPageNumber();
	}
    /**
     * 
     *
     * @return is has next page?
     */
	public boolean isHasNextPage() {
		return getLastPageNumber() > getThisPageNumber();
	}
    /**
     * 
     *
     * @return is has pre page?
     */
	public boolean isHasPreviousPage() {
		return getThisPageNumber() > 1;
	}
    /**
     * 
     *
     * @return get last page number,also is total page
     */
	public int getLastPageNumber() {
		return PageUtils.computeLastPageNumber(totalCount, pageSize);
	}
    /**
     * 
     *
     * @return total record count
     */
	public int getTotalCount() {
		return totalCount;
	}
    /**
     * 
     *
     * @return current page first element record number
     */
	public int getThisPageFirstElementNumber() {
		return (getThisPageNumber() - 1) * getPageSize() + 1;
	}
    /**
     * 
     *
     * @return current page last element record number
     */
	public int getThisPageLastElementNumber() {
		int fullPage = getThisPageFirstElementNumber() + getPageSize() - 1;
		return getTotalCount() < fullPage ? getTotalCount() : fullPage;
	}
    /**
     * 
     *
     * @return next page number
     */
	public int getNextPageNumber() {
		return getThisPageNumber() + 1;
	}
    /**
     * 
     *
     * @return get pre page number
     */
	public int getPreviousPageNumber() {
		return getThisPageNumber() - 1;
	}
    /**
     * 
     *
     * @return page size
     */
	public int getPageSize() {
		return pageSize;
	}
    /**
     * 
     *
     * @return current page number
     */
	public int getThisPageNumber() {
		return pageNumber;
	}

    /**
     * 
     * @return get link page numbers(paging navigator)
     */
	public List<Integer> getLinkPageNumbers() {
		return PageUtils.generateLinkPageNumbers(getThisPageNumber(), getLastPageNumber(),10);
	}
	
	/**
	 * 
	 * @return DB first record
	 */
	public int getFirstResult() {
		return PageUtils.getFirstResult(pageNumber, pageSize);
	}

    public Iterator<T> iterator() {
        return result == null ? Collections.emptyList().iterator() : result.iterator();
    }
}
