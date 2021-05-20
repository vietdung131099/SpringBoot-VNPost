package com.truongvietdung.service.impl;

import com.truongvietdung.entity.Users;
import com.truongvietdung.model.request.user.CustomerUserDetails;
import com.truongvietdung.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users users = usersRepository.findByUserName(userName);
        if(users == null){
            throw new UsernameNotFoundException("User not found");
        }

        return new CustomerUserDetails(users);
    }
}
