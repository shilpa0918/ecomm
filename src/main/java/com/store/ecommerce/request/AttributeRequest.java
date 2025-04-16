package com.store.ecommerce.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AttributeRequest {

    private String attrName;
    private Integer productId;
    private Integer markForDelete;
    private String identifier;
    private String keyword;
}
