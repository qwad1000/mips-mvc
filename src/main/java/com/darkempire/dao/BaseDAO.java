package com.darkempire.dao;

import org.hibernate.Session;

import java.util.List;

/**
 * Created by Сергій on 03.11.2014.
 */
public interface BaseDAO <T>{
    default void update(T entity){
        getCurrentSession().update(entity);
    }
    default T save(T entity){
        getCurrentSession().save(entity);
        return entity;
    }
    default void remove(T entity){
        getCurrentSession().delete(entity);
    }
    T get(int id);
    List<T> list();

    Session getCurrentSession();
}
