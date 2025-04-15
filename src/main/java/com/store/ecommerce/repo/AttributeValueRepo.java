package com.store.ecommerce.repo;

import com.store.ecommerce.entity.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeValueRepo extends JpaRepository<AttributeValue,Integer> {
}
