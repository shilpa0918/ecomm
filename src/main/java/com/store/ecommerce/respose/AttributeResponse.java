package com.store.ecommerce.respose;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AttributeResponse {
    private String attrName;
    private Integer productId;
    private Integer markForDelete;
    private String identifier;
    private String keyword;
}
