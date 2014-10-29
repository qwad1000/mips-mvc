package com.darkempire.dao;

import com.darkempire.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
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
    public User addUser(User user) {
        Serializable ser = sessionFactory.getCurrentSession().save(user);
        System.out.println(ser.getClass()); //todo: test this cast


        User newUser = getUser(user.getEmail());        //warning: id check
        return newUser;
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
    public User getUser(String email) {
        List<User> users = new ArrayList<>();

        Session session = sessionFactory.getCurrentSession();

        users = session
                .createQuery("from User where email=?")
                .setParameter(0, email)
                .list();

        if(users.size()>0)
            return users.get(0);
        return null;
    }

    @Override
    public List<User> listUser() {
        List<User> list =  sessionFactory.getCurrentSession().createQuery("from User")
                .list();
        return list;
    }

    @Override
    public void removeUser(int id) {

    }
}
