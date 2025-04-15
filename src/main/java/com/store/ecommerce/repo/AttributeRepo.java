package com.store.ecommerce.repo;

import com.store.ecommerce.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeRepo extends JpaRepository<Attribute,Integer> {
}
