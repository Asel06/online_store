package com.store.service;

import com.store.entity.User;
import com.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
@Autowired
    UserRepository userRepository;
    public User findById(Integer id){
        return userRepository.findById(id).orElse(null);
    }
}
