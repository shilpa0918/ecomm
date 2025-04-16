package com.store.ecommerce.controller;

import com.store.ecommerce.request.ImageRequest;
import com.store.ecommerce.respose.ImageResponse;
import com.store.ecommerce.service.impl.ImageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/image/v1")
@RequiredArgsConstructor
public class ImageController {

    private final ImageServiceImpl imageService;

    @PostMapping("/addImage")
    public ResponseEntity<ImageResponse> addImage(@RequestBody ImageRequest imageRequest) {
        ImageResponse imageResponse = imageService.addImage(imageRequest);
        return new ResponseEntity<>(imageResponse, HttpStatus.OK);
    }


}
