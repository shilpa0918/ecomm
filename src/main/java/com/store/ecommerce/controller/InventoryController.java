package com.store.ecommerce.controller;

import com.store.ecommerce.request.InventoryRequest;
import com.store.ecommerce.respose.InventoryResponse;
import com.store.ecommerce.service.impl.InventoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/inventory/v1")
public class InventoryController {

    private final InventoryServiceImpl inventoryService;

    @PostMapping("/addInventory")
    public ResponseEntity<InventoryResponse> addInventory(@RequestBody InventoryRequest inventoryRequest){
        InventoryResponse inventoryResponse = inventoryService.addInventory(inventoryRequest);
        return new ResponseEntity<>(inventoryResponse, HttpStatus.CREATED);
    }
}
