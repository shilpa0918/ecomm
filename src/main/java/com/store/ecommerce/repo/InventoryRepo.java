package com.store.ecommerce.repo;

import com.store.ecommerce.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory,Integer> {
}
