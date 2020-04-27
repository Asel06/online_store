package com.store.Controller;

import com.store.Entity.*;
import com.store.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/allUser", method = RequestMethod.GET)
    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User addNewUser (@RequestParam(value = "login")  String login,
                                  @RequestParam  (value = "password") String password,
                                  @RequestParam  (value = "phone") int phone,
                                  @RequestParam (value = "address") List<Address> address,
                                  @RequestParam (value = "role") Role role ) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setPhone(phone);
        user.setAddress(address);
        user.setRole(role);
        return userRepository.save(user);
    }
}
