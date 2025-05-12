package com.store.ecommerce.repo;

import com.store.ecommerce.entity.Attribute;
import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepo extends JpaRepository<Attribute,Integer> {
    Attribute findByAttrName(String attrName);

    void deleteByAttrName(String attrName);
}
