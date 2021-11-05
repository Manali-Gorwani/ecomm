package com.project.sessionmanager.services;

import com.project.sessionmanager.models.CustomerUserDetails;
import com.project.sessionmanager.models.User;
import com.project.sessionmanager.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("No user");
        }
        return new CustomerUserDetails(user);
    }
}
