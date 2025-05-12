package com.store.ecommerce.controller;

import com.store.ecommerce.request.ProductRequest;
import com.store.ecommerce.respose.ProductCategoryResponse;
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
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> productResponses = productService.getAllProducts();
        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }

    @GetMapping("/getProductByName/{productName}")
    public ResponseEntity<ProductResponse> getProductByName(@PathVariable String productName) {
        ProductResponse productResponse = productService.getProductByName(productName);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping("/getProductsByCategory/{categoryName}")
    public ResponseEntity<List<ProductCategoryResponse>> getProductsByCategory(@PathVariable String categoryName) {
        List<ProductCategoryResponse> productResponses = productService.getProductsByCategory(categoryName);
        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }
    @PutMapping("/updateProductById/{productId}")
    public ResponseEntity<ProductResponse> updateProductById(@PathVariable Integer productId,@RequestBody ProductRequest productRequest){
        ProductResponse productResponse = productService.updateProductById(productId,productRequest);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }
    @PostMapping("/addProducts")
    public ResponseEntity<List<ProductResponse>> addProducts(@RequestBody List<ProductRequest> productRequests){
        List<ProductResponse> productResponses = productService.addProducts(productRequests);
        return new ResponseEntity<>(productResponses,HttpStatus.CREATED);

    }
    @PostMapping("/addProductList")
    public ResponseEntity<List<ProductResponse>> addProductList(@RequestBody List<ProductRequest> productRequests){
        List<ProductResponse> productResponses = productService.addProductList(productRequests);
        return new ResponseEntity<>(productResponses,HttpStatus.CREATED);

    }
    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity deleteProduct(@PathVariable Integer productId){
        productService.deleteProduct(productId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
