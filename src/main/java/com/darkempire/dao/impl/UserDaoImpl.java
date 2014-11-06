package com.darkempire.dao.impl;

import com.darkempire.dao.UserDAO;
import com.darkempire.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергій on 22.10.2014.
 */

@Repository
@SuppressWarnings("unchecked")
public class UserDaoImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User get(int id) {
        List<User> users = new ArrayList<>();

        users = getCurrentSession()
                .createQuery("from User where id=?")
                .setParameter(0, id)
                .list();

        if(users.size()>0)
            return users.get(0);
        return null;
    }

    @Override
    public User get(String email) {
        List<User> users = new ArrayList<>();

        users = getCurrentSession()
                .createQuery("from User where email=?")
                .setParameter(0, email)
                .list();

        if(users.size()>0)
            return users.get(0);
        return null;
    }

    @Override
    public List<User> list() {
        List<User> list =  getCurrentSession().createQuery("from User")
                .list();
        return list;
    }

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


}
