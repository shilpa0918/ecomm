package com.store.ecommerce.controller;

import com.store.ecommerce.entity.Product;
import com.store.ecommerce.request.AddProductRequest;
import com.store.ecommerce.request.Attribute_AttributeValue;
import com.store.ecommerce.respose.AttributeValueResponse;
import com.store.ecommerce.respose.PdpProductResponse;
import com.store.ecommerce.service.impl.AddProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addProductApi")
public class AddProductController {

    @Autowired
    AddProductServiceImpl addProductService;

    @PostMapping("/pdpAddProduct")
    public ResponseEntity<PdpProductResponse> pdpAddProduct(@RequestBody AddProductRequest productRequest) {
        PdpProductResponse productResponse = addProductService.pdpAddProduct(productRequest);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @PutMapping("/updateProduct/{productName}")
    public ResponseEntity<PdpProductResponse> updateProduct(@RequestBody AddProductRequest productRequest,
                                                            @PathVariable String productName) {

        PdpProductResponse productResponse = addProductService.updateProduct(productRequest, productName);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping("/getProductsByAttribute/{attributeName}/{attributeValue}")
    public ResponseEntity<List<PdpProductResponse>> getProductByAttributeValue(@PathVariable String attributeName,
                                                                         @PathVariable String attributeValue) {
        List<PdpProductResponse> productResponse = addProductService.getProductsByAttribute(attributeName,attributeValue);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }
}