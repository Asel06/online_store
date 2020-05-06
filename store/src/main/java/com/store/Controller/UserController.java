package com.store.controller;

import com.store.entity.*;
import com.store.repository.UserRepository;
import com.store.service.AddressService;
import com.store.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    AddressService addressService;
    @Autowired
    RoleService roleService;

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
        user.setRole(roleService.findById(form.getRole()));
        return userRepository.save(user);
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.POST)
    public String authorization(@RequestBody UserAuthorization userAuthorization) {
        User user = getByLogin(userAuthorization.getLogin());
        if (user == null) {return "Not user with this login was found";}
        if (user.getPassword().equals(userAuthorization.getPassword())) {return "Authorization was successful!";}
        else {return "Password is wrong";}
    }

    public User getByLogin(String login) {
        return userRepository.getByLogin(login).orElse(null);
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
