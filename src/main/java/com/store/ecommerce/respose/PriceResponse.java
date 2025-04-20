package com.store.ecommerce.respose;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class PriceResponse {
    private BigDecimal price;
    private String priceType; //OFFER, LIST
    private Integer productId;
}
