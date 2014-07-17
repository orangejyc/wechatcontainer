package org.orange.wechatcontainer.service;

import java.io.Serializable;
import java.util.List;

import org.orange.wechatcontainer.dao.EntityDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
//import org.springframework.transaction.annotation.Transactional;

//@Transactional
public abstract class BaseServiceImpl <E,PK extends Serializable> implements BaseService<E, PK>{
	
	protected Log log = LogFactory.getLog(getClass());

	

	/* (non-Javadoc)
	 * @see org.orange.wechatcontainer.service.BaseService#getById(PK)
	 */
	
	//@Transactional(readOnly=true)
	public E getById(PK id) throws DataAccessException{
		return (E)getEntityDao().getById(id);
		
	}
	
	/* (non-Javadoc)
	 * @see org.orange.wechatcontainer.service.BaseService#findAll()
	 */
	
	//@Transactional(readOnly=true)
	public List<E> findAll() throws DataAccessException{
		return getEntityDao().findAll();
	}
	
	/* (non-Javadoc)
	 * @see org.orange.wechatcontainer.service.BaseService#saveOrUpdate(E)
	 */
	public void saveOrUpdate(E entity) throws DataAccessException{
		getEntityDao().saveOrUpdate(entity);
	}
	
	/* (non-Javadoc)
	 * @see org.orange.wechatcontainer.service.BaseService#save(E)
	 */
	public void save(E entity) throws DataAccessException{
		getEntityDao().save(entity);
	}
	
	/* (non-Javadoc)
	 * @see org.orange.wechatcontainer.service.BaseService#removeById(PK)
	 */
	public void removeById(PK id) throws DataAccessException{
		getEntityDao().deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see org.orange.wechatcontainer.service.BaseService#update(E)
	 */
	public void update(E entity) throws DataAccessException{
		getEntityDao().update(entity);
	}
	
	/* (non-Javadoc)
	 * @see org.orange.wechatcontainer.service.BaseService#isUnique(E, java.lang.String)
	 */
	
	//@Transactional(readOnly=true)
	public boolean isUnique(E entity, String uniquePropertyNames) throws DataAccessException {
		return getEntityDao().isUnique(entity, uniquePropertyNames);
	}
	
}
