package com.store.ecommerce.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AttributeValueRequest {
    private String attrValue;
    private Integer attributeId;
    private Integer markForDelete;
    private String identifier;
}
