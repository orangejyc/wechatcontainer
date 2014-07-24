package org.orange.wechatcontainer.dao.hibernate4impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.orange.wechatcontainer.dao.EntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;


public abstract class BaseHibernate4Dao<E, PK extends Serializable> implements EntityDao<E, PK> {

	private Class<E> persistentClass;

	//private final Log log;

	public BaseHibernate4Dao() {
		this.persistentClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		//log = LogFactory.getLog(persistentClass.getClass());
	}
	public BaseHibernate4Dao(Class<E> clazz,PK primaryKey) {
		this.persistentClass = clazz;
		//log = LogFactory.getLog(persistentClass.getClass());
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(E entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void deleteById(PK primaryKey) {
		E entity = getById(primaryKey);
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public void update(E t) {
		sessionFactory.getCurrentSession().update(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getById(PK primaryKey) {
		return (E) sessionFactory.getCurrentSession().get(persistentClass,
				primaryKey);
	}

	@Override
	public void saveOrUpdate(E entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public List<E> findAll() {
		String hql = "from " + persistentClass.getSimpleName();
		return queryForList(hql, null);
	}

	public boolean isUnique(E entity, String uniquePropertyNames) {
		throw new UnsupportedOperationException();
	}

	/** use to hibernate.flush() some dao nee no imp this */
	public void flush() {
		sessionFactory.getCurrentSession().flush();
	}

	public List findBySql2Object(String sql, boolean isHql) {
		//log.debug("finding all " + this.persistentClass.getName()+ "  instances");
		try {
			Query query = null;
			if (isHql) {
				query = this.getSession().createQuery(sql);
				// .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			} else {
				query = this.getSession().createSQLQuery(sql);
				// .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			}
			return query.list();
		} catch (RuntimeException re) {
			//log.error("find all " + this.persistentClass.getName() + "  failed",re);
			throw re;
		}
	}

	public List findBySql(String sql, boolean isHql) {
		//log.debug("finding all " + this.persistentClass.getName()+ "  instances");
		try {
			Query query = null;
			if (isHql) {
				query = this.getSession().createQuery(sql)
						.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			} else {
				query = this.getSession().createSQLQuery(sql)
						.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			}
			return query.list();
		} catch (RuntimeException re) {
			//log.error("find all " + this.persistentClass.getName() + "  failed",re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	protected E queryForObject(String hql, Object[] params) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		setQueryParams(query, params);
		return (E) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	protected E queryForTopObject(String hql, Object[] params) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		setQueryParams(query, params);
		return (E) query.setFirstResult(0).setMaxResults(1).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	protected List<E> queryForList(String hql, Object[] params) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		setQueryParams(query, params);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	protected List<E> queryForList(final String hql, final Object[] params,
			final int recordNum) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		setQueryParams(query, params);
		return query.setFirstResult(0).setMaxResults(recordNum).list();
	}

	private void setQueryParams(Query query, Object[] params) {
		if (null == params) {
			return;
		}
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
