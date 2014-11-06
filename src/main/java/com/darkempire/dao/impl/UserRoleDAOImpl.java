package com.darkempire.dao.impl;

import com.darkempire.dao.UserRoleDAO;
import com.darkempire.model.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Сергій on 29.10.2014.
 */

@Repository
@SuppressWarnings("unchecked")
public class UserRoleDAOImpl implements UserRoleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Set<UserRole> getUserRolesByUserId(int id) {
        Set<UserRole> collection;

        collection = (Set) getCurrentSession().createQuery("from UserRole where id=?")
                .setParameter(0, id)
                .list().stream().collect(Collectors.toSet());

        return collection;

    }

    @Override
    public Set<UserRole> saveUserRoles(Set<UserRole> userRoles) {
        for(UserRole role : userRoles) {
            getCurrentSession().save(role);
        }

        return userRoles;
    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}
