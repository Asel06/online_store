package com.store.service;

import com.store.entity.Cart;
import com.store.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
@Autowired
    CartRepository cartRepository;
    public Cart findById(Integer id){
        return cartRepository.findById(id).orElse(null);
    }
}
