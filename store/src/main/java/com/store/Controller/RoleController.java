package com.store.controller;

import com.store.entity.Role;
import com.store.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/role")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value = "/allRole", method = RequestMethod.GET)
    public Iterable<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public Role addNewRole (@RequestBody Role role) {
        return roleRepository.save(role);
    }

}
