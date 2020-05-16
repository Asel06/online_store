package com.store.controller;

import com.store.entity.Category;
import com.store.entity.Manufactor;
import com.store.repository.CategoryRepository;
import com.store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public Category addNewCategory (@RequestBody Category category ) {
        return categoryRepository.save(category);
    }

    @RequestMapping(value = "/allCategory", method = RequestMethod.GET)
    public Iterable<Category> getallCategory() {
        return categoryRepository.findAll();
    }

    @RequestMapping(value = "/getCategory/{id}", method = RequestMethod.GET)
    public Category findById(@PathVariable("id") int id) {
        return categoryService.findById(id);
    }

    @RequestMapping(value = "/deleteCategory/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCategory(@PathVariable("id") int id) {
        return categoryRepository.findById(id)
                .map(record -> {
                    categoryRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
