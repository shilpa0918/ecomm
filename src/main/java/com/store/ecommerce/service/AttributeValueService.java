package com.store.ecommerce.service;

import com.store.ecommerce.request.AttributeValueRequest;
import com.store.ecommerce.respose.AttributeValueResponse;

import java.util.List;

public interface AttributeValueService {
    AttributeValueResponse addAttributeValue(AttributeValueRequest attributeValueRequest);

    List<AttributeValueResponse> getAllAttributeValues();
}
