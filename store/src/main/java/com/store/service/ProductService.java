package com.store.service;

import com.store.entity.Product;
import com.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public Product findById(Integer id){
        return productRepository.findById(id).orElse(null);
    }
}
