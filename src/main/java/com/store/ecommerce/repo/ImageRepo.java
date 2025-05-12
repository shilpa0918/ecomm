package com.store.ecommerce.repo;

import com.store.ecommerce.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<Image,Integer> {
    Image findByImageUrl(String imageUrl);
}
