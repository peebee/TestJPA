package fr.tuto.annuairejpa.dao;

import java.util.List;

/**
 *
 * @author Pascal
 */
public interface IDao<T, PK> {

    void persist(T entity);

    void remove(T entity);

    T merge(T entity);

    T find(PK id);

    List<T> findAll();
}