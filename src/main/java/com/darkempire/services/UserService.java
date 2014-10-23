package com.darkempire.services;

import com.darkempire.model.User;

import java.util.List;

/**
 * Created by Сергій on 22.10.2014.
 */
public interface UserService {

    public void addUser(User user);
    public User getUser(int id);
    public List<User> allUsers();
    public void removeUser(int id);

}
