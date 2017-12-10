package ua.pizzeria.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ua.pizzeria.dao.BasicDAO;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.List;

abstract class AbstractDAOImpl<T> implements BasicDAO<T> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractDAOImpl.class);
    private Class<T> tClass;

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public AbstractDAOImpl() {
        final ParameterizedType entityClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.tClass = (Class<T>) entityClass.getActualTypeArguments()[0];
    }

    public List<T> getAll() {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(tClass);
        Root<T> root = criteriaQuery.from(tClass);
        criteriaQuery.select(root);

        logger.debug("List<T> getAll() {} " + root);

        return sessionFactory.getCurrentSession().createQuery(criteriaQuery).list();
    }

    public T getById(Integer id) {
        return (T) getCurrentSession().get(tClass, id);
    }

    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    public void add(T entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void save(T entity) {
        getCurrentSession().persist(entity);
    }

    public void merge(T entity) {
        getCurrentSession().merge(entity);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
