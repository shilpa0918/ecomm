package com.store.ecommerce.service;

import com.store.ecommerce.request.AttributeRequest;
import com.store.ecommerce.respose.AttributeResponse;

import java.util.List;

public interface AttributeService {
    AttributeResponse addAttribute(AttributeRequest attributeRequest);

    List<AttributeResponse> getAllAttributes();
}
