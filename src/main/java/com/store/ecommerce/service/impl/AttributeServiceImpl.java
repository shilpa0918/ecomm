package com.store.ecommerce.service.impl;

import com.store.ecommerce.entity.Attribute;
import com.store.ecommerce.entity.Product;
import com.store.ecommerce.repo.AttributeRepo;
import com.store.ecommerce.repo.ProductRepo;
import com.store.ecommerce.request.AttributeRequest;
import com.store.ecommerce.respose.AttributeResponse;
import com.store.ecommerce.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private AttributeRepo attributeRepo;
    @Autowired
    private ProductRepo productRepo;

    @Override
    public AttributeResponse addAttribute(AttributeRequest attributeRequest) {
        Attribute attribute = new Attribute();
        attribute.setAttrName(attributeRequest.getAttrName());
        Product product = productRepo.findById(attributeRequest.getProductId()).get();
        attribute.setProduct(product);
        Attribute savedAttribute = attributeRepo.saveAndFlush(attribute);
        return convertedIntoAttributeDto(savedAttribute);
    }


    private AttributeResponse convertedIntoAttributeDto(Attribute savedAttribute) {
        AttributeResponse attributeResponse = new AttributeResponse();
        attributeResponse.setAttrName(savedAttribute.getAttrName());
        attributeResponse.setProductId(savedAttribute.getProduct().getId());
        return attributeResponse;
    }

    @Override
    public List<AttributeResponse> getAllAttributes() {
        List<Attribute> attributes = attributeRepo.findAll();
        return attributes.stream().map(this::convertedIntoAttributeDto).collect(Collectors.toList());
    }
}
