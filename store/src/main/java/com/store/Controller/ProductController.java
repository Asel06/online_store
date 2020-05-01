package com.store.controller;

import com.store.entity.Product;
import com.store.entity.ProductForm;
import com.store.repository.ProductRepository;
import com.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    private ProductService productService;

    @RequestMapping(value = "/allProduct", method = RequestMethod.GET)
    public Iterable<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public Product addNewProduct (@RequestBody ProductForm product ) {
        return productService.register(product);
    }

    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("id") int id) {
        return productRepository.findById(id)
                .map(record -> {
                    productRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id,
                                                 @RequestBody Product product) {
        return productRepository.findById(id)
                .map(record -> {
                    record.setName(product.getName());
                    record.setQuantity(product.getQuantity());
                    record.setPrice(product.getPrice());
                    record.setManufactor(product.getManufactor());
                    record.setCategory(product.getCategory());

                    Product updated = productRepository.save(product);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
}
