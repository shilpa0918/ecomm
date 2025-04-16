package com.store.ecommerce.service;

import com.store.ecommerce.request.PriceRequest;
import com.store.ecommerce.respose.PriceResponse;

public interface PriceService {
    PriceResponse addPrice(PriceRequest priceRequest);
}
