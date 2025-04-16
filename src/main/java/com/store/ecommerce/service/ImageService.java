package com.store.ecommerce.service;

import com.store.ecommerce.request.ImageRequest;
import com.store.ecommerce.respose.ImageResponse;

public interface ImageService {
    ImageResponse addImage(ImageRequest imageRequest);
}
