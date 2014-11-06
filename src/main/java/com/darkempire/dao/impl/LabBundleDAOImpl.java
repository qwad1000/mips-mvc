package com.darkempire.dao.impl;

import com.darkempire.dao.LabBundleDAO;
import com.darkempire.model.LabBundle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергій on 05.11.2014.
 */
@Repository
public class LabBundleDAOImpl implements LabBundleDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public LabBundle get(int id) {
        List<LabBundle> list = new ArrayList<>();

        list = getCurrentSession().createQuery("from LabBundle where id=?")
                .setParameter(0, id)
                .list();

        if(list.size()>0)
            return list.get(0);
        return null;
    }

    @Override
    public List<LabBundle> list() {
        List<LabBundle> list = new ArrayList<>();

        list = getCurrentSession().createQuery("from LabBundle")
                .list();

        if(list.size()>0)
            return list;
        return null;
    }

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
