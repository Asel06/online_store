package com.store.controller;

import com.store.entity.Role;
import com.store.entity.User;
import com.store.model.CustomUserDetails;
import com.store.model.UserForm;
import com.store.repository.UserRepository;
import com.store.service.AddressService;
import com.store.service.RoleService;
import com.store.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    AddressService addressService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    CustomUserDetails customUserDetails;

    @RequestMapping(value = "/allUser", method = RequestMethod.GET)
    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User addNewUser (@RequestBody UserForm form ) {
        User user = new User();
        user.setLogin(form.getLogin());
        user.setPassword(form.getPassword());
        user.setPhone(form.getPhone());
        user.setAddress(addressService.findById(form.getAddress()));
        user.setRole((Set<Role>) roleService.findById(form.getRole()));
        return userRepository.save(user);
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.POST)
    public User authorization (@RequestBody UserForm form ) {
        User user = (User) userDetailsService.loadUserByUsername(form.getLogin());
        if (user != null && form.getPassword() == user.getPassword()){
            UserDetails userDetails =
                    new org.springframework.security.core.userdetails.User(user.getLogin(),
                            user.getPassword(), customUserDetails.getAuthorities() );
            return (User) userDetails;
        }
        return null;
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        return userRepository.findById(id)
                .map(record -> {
                    userRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
