package org.perform.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.perform.hibernate.misc.Safe;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Dao {

  @Resource
  private SessionFactory sessionFactory;

  public Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  public void save(Object entity) {
    getSession().saveOrUpdate(entity);
  }

  public void delete(Object entity) {
    getSession().delete(entity);
  }

  public <MODEL, ID extends Serializable> MODEL load(Class<MODEL> modelClass, ID id) {
    return Safe.cast(getSession().load(modelClass, id));
  }

  public <MODEL, ID extends Serializable> MODEL get(Class<MODEL> modelClass, ID id) {
    return Safe.cast(getSession().get(modelClass, id));
  }

  public <MODEL> List<MODEL> list(Class<MODEL> modelClass) {
    Criteria criteria = getSession().createCriteria(modelClass);
    return Safe.cast(criteria.list());
  }
}
