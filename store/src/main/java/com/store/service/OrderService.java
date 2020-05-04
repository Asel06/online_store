package com.store.service;

import com.store.entity.Order;
import com.store.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    public Order findById(Integer id){
        return orderRepository.findById(id).orElse(null);
    }
}
