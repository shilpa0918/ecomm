package com.store.ecommerce.controller;

import com.store.ecommerce.request.ProductRequest;
import com.store.ecommerce.respose.ProductResponse;
import com.store.ecommerce.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product/v1")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/addProduct")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.addProduct(productRequest);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        List<ProductResponse> productResponses = productService.getAllProducts();
        return new ResponseEntity<>(productResponses,HttpStatus.OK);
    }

    @GetMapping("/getProductByName/{productName}")
    public ResponseEntity<ProductResponse> getProductByName(@PathVariable  String productName){
        ProductResponse productResponse = productService.getProductByName(productName);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }
}
