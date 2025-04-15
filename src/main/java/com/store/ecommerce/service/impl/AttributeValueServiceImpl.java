package com.store.ecommerce.service.impl;

import com.store.ecommerce.entity.Attribute;
import com.store.ecommerce.entity.AttributeValue;
import com.store.ecommerce.repo.AttributeRepo;
import com.store.ecommerce.repo.AttributeValueRepo;
import com.store.ecommerce.request.AttributeValueRequest;
import com.store.ecommerce.respose.AttributeValueResponse;
import com.store.ecommerce.service.AttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttributeValueServiceImpl implements AttributeValueService {

    @Autowired
    private AttributeValueRepo attributeValueRepo;
    @Autowired
    private AttributeRepo attributeRepo;

    @Override
    public AttributeValueResponse addAttributeValue(AttributeValueRequest attributeValueRequest) {
        AttributeValue attributeValue = new AttributeValue();
        Attribute attribute = attributeRepo.findById(attributeValueRequest.getAttributeId()).get();
        attributeValue.setAttribute(attribute);
        attributeValue.setAttrValue(attributeValueRequest.getAttrValue());
        AttributeValue addedAttributeValue = attributeValueRepo.saveAndFlush(attributeValue);
        return convertedIntoAttributeValueDto(addedAttributeValue);
    }


    private AttributeValueResponse convertedIntoAttributeValueDto(AttributeValue addedAttributeValue) {
        AttributeValueResponse attributeValueResponse = new AttributeValueResponse();
        attributeValueResponse.setAttributeId(addedAttributeValue.getAttribute().getId());
        attributeValueResponse.setAttrValue(addedAttributeValue.getAttrValue());
        return attributeValueResponse;
    }

    @Override
    public List<AttributeValueResponse> getAllAttributeValues() {
        List<AttributeValue> attributeValues = attributeValueRepo.findAll();
        return attributeValues.stream().map(this::convertedIntoAttributeValueDto).collect(Collectors.toList());
    }
}
