package com.store.ecommerce.respose;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttributeValueResponse {
    private String attrValue;
    private Integer attributeId;
    private Integer markForDelete;
    private String identifier;
    private String keyword;
}
