package com.store.ecommerce.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ImageRequest {
    private String imageUrl;
    private Integer productId;
}
