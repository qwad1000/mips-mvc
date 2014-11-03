package com.darkempire.dao;

import com.darkempire.model.User;

/**
 * Created by Сергій on 22.10.2014.
 */
public interface UserDAO extends BaseDAO<User>{
    public User get(String email);
}
