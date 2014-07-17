package org.orange.wechatcontainer.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import org.orange.wechatcontainer.dao.EntityDao;

public interface BaseService<E, PK extends Serializable> {

	//@Transactional(readOnly = true)
	public  E getById(PK id) throws DataAccessException;

	//@Transactional(readOnly = true)
	public  List<E> findAll() throws DataAccessException;

	/** insert or update data by ID */
	public  void saveOrUpdate(E entity) throws DataAccessException;

	/** insert data */
	public  void save(E entity) throws DataAccessException;

	public  void removeById(PK id) throws DataAccessException;

	public  void update(E entity) throws DataAccessException;

	//@Transactional(readOnly = true)
	public boolean isUnique(E entity, String uniquePropertyNames)
			throws DataAccessException;
	
	//public EntityDao<E,PK> getEntityDao();
	public EntityDao getEntityDao();

}