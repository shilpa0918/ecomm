package com.store.ecommerce.repo;

import com.store.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    Product findByProductName(String productName);

    List<Product> findByCategoryCategoryName(String categoryName);
}
