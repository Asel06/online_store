package com.store.controller;

import com.store.entity.*;
import com.store.repository.CartItemRepository;
import com.store.service.CartService;
import com.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cartitem")
public class CartItemController {
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    ProductService productService;
    @Autowired
    CartService cartService;

    @RequestMapping(value = "/allCartItem", method = RequestMethod.GET)
    public Iterable<CartItem> getAllCartItem() {
        return cartItemRepository.findAll();
    }

    @RequestMapping(value = "/addCartItem", method = RequestMethod.POST)
    public CartItem addCartItem (@RequestBody CartItemForm form ) {
        CartItem cartItem = new CartItem();
        cartItem.setCart(cartService.findById(form.getCartId()));
        cartItem.setProduct(productService.findById(form.getProduct()));
        cartItem.setQuantity(form.getQuantity());
        cartItem.setPrice(form.getPrice());
        return cartItemRepository.save(cartItem);
    }

    @RequestMapping(value = "/deleteCartItem/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCartItem(@PathVariable("id") int id) {
        return cartItemRepository.findById(id)
                .map(record -> {
                    cartItemRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
