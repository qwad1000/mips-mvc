package com.darkempire.dao;

import com.darkempire.model.StudentsGroup;

/**
 * Created by Сергій on 03.11.2014.
 */
public interface StudentsGroupDAO extends BaseDAO<StudentsGroup> {
    public StudentsGroup get(String name);
}
