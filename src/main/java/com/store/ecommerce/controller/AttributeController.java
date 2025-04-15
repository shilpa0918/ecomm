package com.store.ecommerce.controller;

import com.store.ecommerce.request.AttributeRequest;
import com.store.ecommerce.respose.AttributeResponse;
import com.store.ecommerce.service.impl.AttributeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attribute/v1")
public class AttributeController {

    @Autowired
    private AttributeServiceImpl attributeService;

    @PostMapping("/addAttribute")
    public ResponseEntity<AttributeResponse> addAttribute(@RequestBody AttributeRequest attributeRequest) {
        AttributeResponse attributeResponse = attributeService.addAttribute(attributeRequest);
        return new ResponseEntity<>(attributeResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getAllAttributes")
    public ResponseEntity<List<AttributeResponse>> getAllAttributes() {
        List<AttributeResponse> attributeResponses = attributeService.getAllAttributes();
        return new ResponseEntity<>(attributeResponses, HttpStatus.OK);
    }

}


