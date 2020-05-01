package com.store.controller;

import com.store.entity.Category;
import com.store.entity.Manufactor;
import com.store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public Category addNewCategory (@RequestBody Category category ) {
        return categoryRepository.save(category);
    }
}
