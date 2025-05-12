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
import java.util.NoSuchElementException;
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
        //handle conditional addition of attribute
        if(attributeRequest.getProductId() != null){
            // If product is there in the request, consider this request as assigning the attribute
            Product product = productRepo.findById(attributeRequest.getProductId())
                    .orElseThrow(() -> new NoSuchElementException("Product not found with productId: "+ attributeRequest.getProductId()));
            attribute.setProduct(product);
        }
        attribute.setKeyword(attributeRequest.getKeyword());
        attribute.setIdentifier(attributeRequest.getIdentifier());
        attribute.setMarkForDelete(attributeRequest.getMarkForDelete());
        Attribute savedAttribute = attributeRepo.saveAndFlush(attribute);
        return convertedIntoAttributeDto(savedAttribute);
    }


    private AttributeResponse convertedIntoAttributeDto(Attribute savedAttribute) {
        AttributeResponse attributeResponse = new AttributeResponse();
        attributeResponse.setAttrName(savedAttribute.getAttrName());
        if(savedAttribute.getProduct() != null){
            attributeResponse.setProductId(savedAttribute.getProduct().getId());
        }
        attributeResponse.setKeyword(savedAttribute.getKeyword());
        attributeResponse.setIdentifier(savedAttribute.getIdentifier());
        attributeResponse.setMarkForDelete(savedAttribute.getMarkForDelete());
        return attributeResponse;
    }

    @Override
    public List<AttributeResponse> getAllAttributes() {
        List<Attribute> attributes = attributeRepo.findAll();
        return attributes.stream().map(this::convertedIntoAttributeDto).collect(Collectors.toList());
    }

    @Override
    public void deleteByAttributeName(String attrName) {
        attributeRepo.deleteByAttrName(attrName);
    }

    @Override
    public void deleteByAttributeId(String attrId) {
        attributeRepo.deleteById(Integer.valueOf(attrId));
    }
}
