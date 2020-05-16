package com.store.service;

import com.store.entity.User;
import com.store.model.CustomUserDetails;
import com.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByLogin(login);
        optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("Login not found"));
        return optionalUser.map(CustomUserDetails::new).get();
    }

}
