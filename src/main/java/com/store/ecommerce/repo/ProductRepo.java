package com.store.ecommerce.repo;

import com.store.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    Product findByProductName(String productName);
}
