package com.store.service;

import com.store.entity.Role;
import com.store.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    public Role findById(Integer id){
        return roleRepository.findById(id).orElse(null);
    }
}
