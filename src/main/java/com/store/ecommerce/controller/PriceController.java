package com.store.ecommerce.controller;

import com.store.ecommerce.request.PriceRequest;
import com.store.ecommerce.respose.PriceResponse;
import com.store.ecommerce.service.impl.PriceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/price/v1")
//@RequiredArgsConstructor
public class PriceController {
    @Autowired
    private PriceServiceImpl priceService;

    @PostMapping("/addPrice")
    public ResponseEntity<PriceResponse> addPrice(@RequestBody PriceRequest priceRequest) {
        PriceResponse priceResponse = priceService.addPrice(priceRequest);
        return new ResponseEntity<>(priceResponse, HttpStatus.CREATED);
    }


}
