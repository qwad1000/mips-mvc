package com.darkempire.dao;

import com.darkempire.model.User;

import java.util.List;

/**
 * Created by Сергій on 22.10.2014.
 */
public interface UserDAO {
    public void addUser(User user);
    public User getUser(int id);
    public List<User> listUser();
    public void removeUser(int id);
}
