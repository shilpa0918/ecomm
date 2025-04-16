package com.store.ecommerce.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InventoryRequest {
    private Integer quantity;
    private Integer productId;
}
