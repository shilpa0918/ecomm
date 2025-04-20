package com.store.ecommerce.request;

import com.store.ecommerce.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class PriceRequest {
    private BigDecimal price;
    private String priceType; //OFFER, LIST
    private Integer productId;
}
