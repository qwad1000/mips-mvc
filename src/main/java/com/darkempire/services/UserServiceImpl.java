package com.darkempire.services;

import com.darkempire.dao.UserDAO;
import com.darkempire.dao.UserRoleDAO;
import com.darkempire.model.User;
import com.darkempire.model.UserRole;
import com.darkempire.services.validation.UserExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Сергій on 22.10.2014.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserRoleDAO userRoleDAO;


    @Override
    @Transactional
    public User registerUser(User user) throws UserExistsException {
        if(userExists(user.getEmail())){
            throw new UserExistsException("Account with such mail exists:" + user.getEmail());
        }
        user.setEnabled(true);
        Set<UserRole> roleList = new HashSet<>();
        roleList.add(new UserRole("ROLE_USER", user));
        user.setUserRolesById(roleList); //todo: Enum with roles

        User result = userDAO.addUser(user);
        userRoleDAO.saveUserRoles(roleList);//todo: read if it's crunch and i can only save user
        return result;
    }

    @Override
    @Transactional
    @Deprecated
    public void addUser(User user) throws UserExistsException{
        if(userExists(user.getEmail())){
            throw new UserExistsException("Account with such mail exists:" + user.getEmail());
        }
        userDAO.addUser(user);
    }

    private boolean userExists(String email){
        User user = userDAO.getUser(email);
        return user != null;
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public List<User> allUsers() {
        return userDAO.listUser();
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        userDAO.removeUser(id);
    }
}
