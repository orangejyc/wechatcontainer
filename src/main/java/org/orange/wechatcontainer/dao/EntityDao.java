package org.orange.wechatcontainer.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface EntityDao <E,PK extends Serializable>{
//public interface EntityDao <E>{

	public E getById(PK id) throws DataAccessException;
	
	public void deleteById(PK id) throws DataAccessException;
	
	//public E getById(String id) throws DataAccessException;
	
	//public void deleteById(String id) throws DataAccessException;
	
	/**  */
	public void save(E entity) throws DataAccessException;
	
	/**  */
	public void update(E entity) throws DataAccessException;

	/** */
	public void saveOrUpdate(E entity) throws DataAccessException;

	public boolean isUnique(E entity, String uniquePropertyNames) throws DataAccessException;
	
	/** use to hibernate.flush() some dao nee no imp this  */
	public void flush() throws DataAccessException;
	
	public List<E> findAll() throws DataAccessException;

	
}
