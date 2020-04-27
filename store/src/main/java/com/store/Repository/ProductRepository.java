package com.store.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.store.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
