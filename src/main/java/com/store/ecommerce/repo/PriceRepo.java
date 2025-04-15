package com.store.ecommerce.repo;

import com.store.ecommerce.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepo extends JpaRepository<Price,Integer> {
}
