package com.store.service;

import com.store.entity.Category;
import com.store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public Category findById(Integer id){
        return categoryRepository.findById(id).orElse(null);
    }
}
