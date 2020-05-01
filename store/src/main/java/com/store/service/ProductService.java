package com.store.service;

import com.store.controller.ManufactorController;
import com.store.controller.CategoryController;
import com.store.entity.Manufactor;
import com.store.entity.Category;
import com.store.entity.Product;
import com.store.entity.ProductForm;
import com.store.repository.CategoryRepository;
import com.store.repository.ManufactorRepository;
import com.store.repository.ProductRepository;

public class ProductService {

     ProductRepository productRepository;
     CategoryRepository categoryRepository;
     ManufactorRepository manufactorRepository;
     Manufactor manufactor;
     Category category;
    public Product register(ProductForm form) {

        Product product = new Product();
        product.setName(form.getName());
        product.setPrice(form.getPrice());
        product.setQuantity(form.getQuantity());
        product.setManufactor(manufactorRepository.findById(form.getManufactor()).orElse(ManufactorController.addNewManufactor(manufactor)));
        product.setCategory(categoryRepository.findById(form.getCategory()).orElse(CategoryController.addNewCategory(category)));
        return productRepository.save(product);
    }

}
