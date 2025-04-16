package com.store.ecommerce.service;

import com.store.ecommerce.request.InventoryRequest;
import com.store.ecommerce.respose.InventoryResponse;

public interface InventoryService {
    InventoryResponse addInventory(InventoryRequest inventoryRequest);
}
