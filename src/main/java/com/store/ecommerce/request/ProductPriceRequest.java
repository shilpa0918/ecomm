package com.store.ecommerce.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductPriceRequest {
    private BigDecimal price;
    private String priceType; //OFFER, LIST
}
