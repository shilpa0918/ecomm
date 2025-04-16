package com.store.ecommerce.service.impl;

import com.store.ecommerce.entity.Inventory;
import com.store.ecommerce.entity.Product;
import com.store.ecommerce.repo.InventoryRepo;
import com.store.ecommerce.repo.ProductRepo;
import com.store.ecommerce.request.InventoryRequest;
import com.store.ecommerce.respose.InventoryResponse;
import com.store.ecommerce.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepo inventoryRepo;
    private final ProductRepo productRepo;

    @Override
    public InventoryResponse addInventory(InventoryRequest inventoryRequest) {
        Inventory inventory = new Inventory();
        inventory.setQuantity(inventoryRequest.getQuantity());
        Product product = productRepo.findById(inventoryRequest.getProductId()).get();
        inventory.setProduct(product);
        Inventory addedInventory = inventoryRepo.saveAndFlush(inventory);
        return converetdIntoInventoryDto(addedInventory);
    }

    private InventoryResponse converetdIntoInventoryDto(Inventory addedInventory) {
        InventoryResponse inventoryResponse = new InventoryResponse();
        inventoryResponse.setQuantity(addedInventory.getQuantity());
        inventoryResponse.setProductId(addedInventory.getProduct().getId());
        return inventoryResponse;
    }
}
