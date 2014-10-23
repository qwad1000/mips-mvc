package com.darkempire.dao;

import com.darkempire.model.User;
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
    //@Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getUser(int id) {
        List<User> users = new ArrayList<>();

        users = sessionFactory.getCurrentSession()
                .createQuery("from User where id=?")
                .setParameter(0, id)
                .list();

        if(users.size()>0)
            return users.get(0);
        return null;
    }

    @Override
    public List<User> listUser() {
        return null;
    }

    @Override
    public void removeUser(int id) {

    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}