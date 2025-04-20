package com.store.ecommerce.repo;

import com.store.ecommerce.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepo extends JpaRepository<Attribute,Integer> {
}
