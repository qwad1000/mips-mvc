package com.darkempire.dao.impl;

import com.darkempire.dao.StudentDAO;
import com.darkempire.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергій on 03.11.2014.
 */

@Repository
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Student get(int id) {
        List<Student> list = new ArrayList<>();

        list = getCurrentSession().createQuery("from Student where id=?")
                .setParameter(0, id)
                .list();

        if(list.size()>0)
            return list.get(0);
        return null;
    }

    @Override
    public List<Student> list() {
        List<Student> list = new ArrayList<>();

        list = getCurrentSession().createQuery("from Student").list();
        return list.size()>0 ? list : null;

    }

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
