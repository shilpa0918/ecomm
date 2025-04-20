package com.store.ecommerce.service.impl;

import com.store.ecommerce.entity.Price;
import com.store.ecommerce.entity.Product;
import com.store.ecommerce.repo.PriceRepo;
import com.store.ecommerce.repo.ProductRepo;
import com.store.ecommerce.request.PriceRequest;
import com.store.ecommerce.respose.PriceResponse;
import com.store.ecommerce.respose.ProductResponse;
import com.store.ecommerce.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    private PriceRepo priceRepo;
    private ProductRepo productRepo;
    public PriceServiceImpl(PriceRepo priceRepo,ProductRepo productRepo){
        this.priceRepo = priceRepo;
        this.productRepo = productRepo;
    }

    @Override
    public PriceResponse addPrice(PriceRequest priceRequest) {
        Price price = new Price();
        price.setPriceType(priceRequest.getPriceType());
        price.setPrice(priceRequest.getPrice());
        Product product = productRepo.findById(priceRequest.getProductId()).get();
        price.setProduct(product);
        Price addedprice = priceRepo.saveAndFlush(price);
        return convertedToPriceDto(addedprice);
    }

    private PriceResponse convertedToPriceDto(Price addedprice) {
        PriceResponse priceResponse = new PriceResponse();
        priceResponse.setPriceType(addedprice.getPriceType());
        priceResponse.setPrice(addedprice.getPrice());
        priceResponse.setProductId(addedprice.getProduct().getId());
        return priceResponse;
    }
}
