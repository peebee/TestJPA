/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.tuto.annuairejpa.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Pascal
 */
public abstract class Dao<T, PK> implements IDao<T, PK> {

    protected Class<T> entityType;
    protected EntityManager em;

    @SuppressWarnings("unchecked")
    public Dao() {
        ParameterizedType genericSuperclass =
                (ParameterizedType) getClass().getGenericSuperclass();
        this.entityType = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    @Override
    public T find(PK id) {
        return em.find(entityType, id);
    }

	@SuppressWarnings("unchecked")
	@Override
    public List<T> findAll() {
        String all = "select x from " + entityType.getSimpleName() + " x";
        List<T> resultList = (List<T>) em.createQuery(all).getResultList();
		return resultList;
    }

    @Override
    public T merge(T entity) {
        return em.merge(entity);
    }

    @Override
    public void persist(T entity) {
        em.persist(entity);
    }

    @Override
    public void remove(T entity) {
        em.refresh(entity);
    }
}
