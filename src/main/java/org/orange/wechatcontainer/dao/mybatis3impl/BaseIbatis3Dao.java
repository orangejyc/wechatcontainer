package org.orange.wechatcontainer.dao.mybatis3impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.util.Assert;
import org.orange.wechatcontainer.common.Page;
import org.orange.wechatcontainer.common.PageRequest;
import org.orange.wechatcontainer.dao.EntityDao;
import org.orange.wechatcontainer.util.PropertyUtils;

public abstract class BaseIbatis3Dao<E,PK extends Serializable> extends DaoSupport implements EntityDao<E,PK> {
    protected final Log log = LogFactory.getLog(getClass());
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	protected void checkDaoConfig() throws IllegalArgumentException {
		Assert.notNull(sqlSessionFactory,"sqlSessionFactory must be not null");
	}

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	

    public SqlSessionTemplate getSqlSessionTemplate() {
    	//sqlSessionTemplate.selectList(statement)
    	return sqlSessionTemplate;
    }
    
    /*
    public Object getById(PK primaryKey) {
        Object object = getSqlSessionTemplate().selectOne(getFindByPrimaryKeyStatement(), primaryKey);
        return object;
    }*/
    
    
    public E getById(PK primaryKey) {
        Object object = getSqlSessionTemplate().selectOne(getFindByPrimaryKeyStatement(), primaryKey);
        return (E)object;
    }
    
	public void deleteById(PK id) {
		int affectCount = getSqlSessionTemplate().delete(getDeleteStatement(), id);
	}
	
    public void save(E entity) {
		prepareObjectForSaveOrUpdate(entity);
		int affectCount = getSqlSessionTemplate().insert(getInsertStatement(), entity);    	
    }
    
	public void update(E entity) {
		prepareObjectForSaveOrUpdate(entity);
		int affectCount = getSqlSessionTemplate().update(getUpdateStatement(), entity);
	}
	
	/**
	 * 
	 * @param o
	 */
    protected void prepareObjectForSaveOrUpdate(E o) {
    }

    /*
    public String getIbatisMapperNamesapce() {
        throw new RuntimeException("not yet implement");
    }*/
    
    public abstract String getIbatisMapperNamesapce();
    
    public String getFindByPrimaryKeyStatement() {
        return getIbatisMapperNamesapce()+".getById";
    }

    public String getInsertStatement() {
        return getIbatisMapperNamesapce()+".insert";
    }

    public String getUpdateStatement() {
    	return getIbatisMapperNamesapce()+".update";
    }

    public String getDeleteStatement() {
    	return getIbatisMapperNamesapce()+".delete";
    }

    public String getCountStatementForPaging(String statementName) {
		return statementName +".count";
	}
    
	protected Page pageQuery(String statementName, PageRequest pageRequest) {
		return pageQuery(getSqlSessionTemplate(),statementName,getCountStatementForPaging(statementName),pageRequest);
	}
	
	public static Page pageQuery(SqlSessionTemplate sqlSessionTemplate,String statementName,String countStatementName, PageRequest pageRequest) {
		
		Number totalCount = (Number) sqlSessionTemplate.selectOne(countStatementName,pageRequest);
		if(totalCount == null || totalCount.longValue() <= 0) {
			return new Page(pageRequest,0);
		}
		
		Page page = new Page(pageRequest,totalCount.intValue());
		
		//other paging parameters,for users who cannot paging by (Dialect). using below with getSqlMapClientTemplate().queryForList(statementName, parameterObject)
		Map filters = new HashMap();
		filters.put("offset", page.getFirstResult());
		filters.put("pageSize", page.getPageSize());
		filters.put("lastRows", page.getFirstResult() + page.getPageSize());
		filters.put("sortColumns", pageRequest.getSortColumns());
		
		Map parameterObject = PropertyUtils.describe(pageRequest);
		filters.putAll(parameterObject);
		
		List list = sqlSessionTemplate.selectList(statementName, filters, new RowBounds(page.getFirstResult(),page.getPageSize()));
				
		page.setResult(list);
		return page;
	}
	
	public List findAll() {
		throw new UnsupportedOperationException();
	}
	
	public void saveOrUpdate(E entity) {
		throw new UnsupportedOperationException();
	}

	public boolean isUnique(E entity, String uniquePropertyNames) {
		throw new UnsupportedOperationException();
	}
	
	public void flush() {
		//ignore
	}
	
	
	
	
}
