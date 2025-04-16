package com.store.ecommerce.service.impl;

import com.store.ecommerce.entity.Image;
import com.store.ecommerce.entity.Product;
import com.store.ecommerce.repo.ImageRepo;
import com.store.ecommerce.repo.ProductRepo;
import com.store.ecommerce.request.ImageRequest;
import com.store.ecommerce.respose.ImageResponse;
import com.store.ecommerce.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepo imageRepo;
    private final ProductRepo productRepo;

    @Override
    public ImageResponse addImage(ImageRequest imageRequest) {
        Image image = new Image();
        image.setImageUrl(imageRequest.getImageUrl());
        Product product = productRepo.findById(imageRequest.getProductId()).get();
        image.setProduct(product);
        Image addedImage = imageRepo.saveAndFlush(image);
        return convertedIntoImageDto(addedImage);
    }

    private ImageResponse convertedIntoImageDto(Image addedImage) {
        ImageResponse imageResponse = new ImageResponse();
        imageResponse.setImageUrl(addedImage.getImageUrl());
        imageResponse.setProductId(addedImage.getProduct().getId());
        return imageResponse;
    }
}
