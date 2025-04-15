package com.store.ecommerce.repo;

import com.store.ecommerce.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Image,Integer> {
}
