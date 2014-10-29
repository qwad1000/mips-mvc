package com.darkempire.dao;

import com.darkempire.model.UserRole;

import java.util.Set;

/**
 * Created by Сергій on 29.10.2014.
 */
public interface UserRoleDAO {
    Set<UserRole> getUserRolesByUserId(int id);
    Set<UserRole> saveUserRoles(Set<UserRole> userRoles);
}
