package com.store.ecommerce.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductInventoryRequest {
    private Integer quantity;
    private Long storeId;
}

