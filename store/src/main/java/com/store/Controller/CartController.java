package com.store.controller;

import com.store.entity.Cart;
import com.store.entity.CartForm;
import com.store.repository.CartRepository;
import com.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cart")
public class CartController {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/allCart", method = RequestMethod.GET)
    public Iterable<Cart> getAllCart() {
        return cartRepository.findAll();
    }

    @RequestMapping(value = "/addCart", method = RequestMethod.POST)
    public Cart addNewCart (@RequestBody CartForm form ) {
        Cart cart = new Cart();
        cart.setUser(userService.findById(form.getUser()));
        cart.setPrice(form.getPrice());
        return cartRepository.save(cart);
    }

    @RequestMapping(value = "/deleteCart/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCart(@PathVariable("id") int id) {
        return cartRepository.findById(id)
                .map(record -> {
                    cartRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
