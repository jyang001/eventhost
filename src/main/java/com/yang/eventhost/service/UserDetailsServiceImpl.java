package com.yang.eventhost.service;

import com.yang.eventhost.repository.UserDAO;
import com.yang.eventhost.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = this.userDAO.findUserAccount(username);

        if(user == null) {
            System.out.println("User not found" + username);
            throw new UsernameNotFoundException("User " + username + "was not found in the database");
        }

        System.out.println("Found User: " + user.getUsername());

        UserDetails userDetails = (UserDetails) new User(user.getFirstName(), user.getLastName(),user.getUsername(), user.getPassword(), user.getEmail());

        System.out.println("casted woohoo");

        return userDetails;
    }

}
