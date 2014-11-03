package com.darkempire.services;

import com.darkempire.model.User;
import com.darkempire.services.validation.UserExistsException;

import java.util.List;

/**
 * Created by Сергій on 22.10.2014.
 */
public interface UserService {

    public User registerUser(User user) throws UserExistsException;
    @Deprecated
    public void addUser(User user) throws UserExistsException;
    public User getUser(int id);
    public List<User> allUsers();
    public void removeUser(int id);
}
