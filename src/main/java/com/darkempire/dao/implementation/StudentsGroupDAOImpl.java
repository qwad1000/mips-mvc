package com.darkempire.dao.implementation;

import com.darkempire.dao.StudentsGroupDAO;
import com.darkempire.model.StudentsGroup;
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
public class StudentsGroupDAOImpl implements StudentsGroupDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public StudentsGroup get(int id) {
        List<StudentsGroup> groups = new ArrayList<>();

        groups = sessionFactory.getCurrentSession()
                .createQuery("from StudentsGroup where id=?")
                .setParameter(0, id)
                .list();

        if(groups.size()>0)
            return groups.get(0);
        return null;
    }

    @Override
    public StudentsGroup get(String name) {
        List<StudentsGroup> groups = new ArrayList<>();

        groups = sessionFactory.getCurrentSession()
                .createQuery("from StudentsGroup where name=?")
                .setParameter(0, name)
                .list();

        if(groups.size()>0)
            return groups.get(0);
        return null;
    }

    @Override
    public List<StudentsGroup> list() {
        List<StudentsGroup> groups = new ArrayList<>();

        groups = sessionFactory.getCurrentSession()
                .createQuery("from StudentsGroup")
                .list();

        if(groups.size()>0)
            return groups;
        return null;
    }

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
