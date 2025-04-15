package com.store.ecommerce.controller;

import com.store.ecommerce.request.AttributeValueRequest;
import com.store.ecommerce.respose.AttributeValueResponse;
import com.store.ecommerce.service.impl.AttributeValueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attributeValue/v1")
public class AttributeValueController {

    @Autowired
    AttributeValueServiceImpl attributeValueService;

    @PostMapping("/addAttributeValue")
    public ResponseEntity<AttributeValueResponse> addAttributeValue(
            @RequestBody AttributeValueRequest attributeValueRequest) {
        AttributeValueResponse attributeValueResponse = attributeValueService.addAttributeValue(attributeValueRequest);
        return new ResponseEntity<>(attributeValueResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getAllAttributeValues")
    public ResponseEntity<List<AttributeValueResponse>> getAllAttributeValues() {
        List<AttributeValueResponse> attributeResponse = attributeValueService.getAllAttributeValues();
        return new ResponseEntity<>(attributeResponse, HttpStatus.OK);
    }


}
