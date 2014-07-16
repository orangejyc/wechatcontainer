package org.orange.wechatcontainer.plugins;

/**
 * Dialect like hibernate,but only has paging function
 * 
 */
public class Dialect {
	
    public boolean supportsLimit(){
    	return false;
    }

    public boolean supportsLimitOffset() {
    	return supportsLimit();
    }
    
    /**
     * offset,limit.</br>
     * getLimitString(sql,offset,String.valueOf(offset),limit,String.valueOf(limit))
     */
    public String getLimitString(String sql, int offset, int limit) {
    	return getLimitString(sql,offset,Integer.toString(offset),limit,Integer.toString(limit));
    }
    
    /**
     *
     * <pre>
     * mysql
     * dialect.getLimitString("select * from user", 12, ":offset",0,":limit") will return
     * select * from user limit :offset,:limit
     * </pre>
     * @return paging sql includes placeholder
     */
    public String getLimitString(String sql, int offset,String offsetPlaceholder, int limit,String limitPlaceholder) {
    	throw new UnsupportedOperationException("paged queries not supported");
    }
    
}
