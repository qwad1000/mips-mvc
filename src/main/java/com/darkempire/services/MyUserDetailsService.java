package com.darkempire.services;

import com.darkempire.dao.UserDAO;
import com.darkempire.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by Сергій on 27.10.2014.
 */
public class MyUserDetailsService implements UserDetailsService {

    //Logger logger = Logger.getLogger("MyUserDetailsService");

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException, DataAccessException {
        com.darkempire.model.User user = userDAO.getUser(email);
//        if(user == null){
//            throw new UsernameNotFoundException("No user with such username(or email)" + email);
//        }
        List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRolesById());

        return buildUserForAuthentication(user, authorities);
    }

    private User buildUserForAuthentication(com.darkempire.model.User user,
                                            List<GrantedAuthority> authorities) {
        boolean enabled = user.isEnabled();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return new User(user.getEmail(), user.getPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Collection<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }
}
