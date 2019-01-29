package com.yang.eventhost.service;

import com.yang.eventhost.entity.Account;
import com.yang.eventhost.repository.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Account account = this.accountDAO.findUserAccount(username);

        if(account == null) {
            System.out.println("User not found" + username);
            throw new UsernameNotFoundException("User " + username + "was not found in the database");
        }

        System.out.println("Found User: " + account.getUsername());

        List<GrantedAuthority> userAuthorityList = new ArrayList<GrantedAuthority>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
        userAuthorityList.add(grantedAuthority);

        UserDetails userDetails = (UserDetails) new User(account.getUsername(), account.getPassword(), userAuthorityList);

        return userDetails;
    }

}
