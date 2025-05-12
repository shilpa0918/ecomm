package com.store.ecommerce.service.impl;

import com.store.ecommerce.entity.*;
import com.store.ecommerce.repo.CategoryRepo;
import com.store.ecommerce.repo.UserRepo;
import com.store.ecommerce.request.UserRequest;
import com.store.ecommerce.respose.UserResponse;
import com.store.ecommerce.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    UserRepo userRepo;

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        Users user = new Users();
        user.setName(userRequest.getName());
        user.setCreatedAt(userRequest.getCreatedAt());
        user.setUpdatedAt(userRequest.getUpdatedAt());
        user.setAge(userRequest.getAge());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        List<Address> addresses = userRequest.getAddresses().stream().map(city -> Address.builder()
                    .city(city)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .users(user)
                    .build()
        ).toList();
        user.setAddresses(addresses);
        Users addedUser = userRepo.saveAndFlush(user);
        return convertedToUserDto(addedUser);
    }


    private UserResponse convertedToUserDto(Users addedUser) {
        UserResponse userResponse = new UserResponse();
        userResponse.setName(addedUser.getName());
        userResponse.setCreatedAt(addedUser.getCreatedAt());
        userResponse.setUpdatedAt(addedUser.getUpdatedAt());
        userResponse.setAge(addedUser.getAge());
        return userResponse;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<Users> users = userRepo.findAll();
        return users.stream().map(this::convertedToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserByName(String userName) {
        Users user = userRepo.findByName(userName);
        return convertedToUserDto(user);
    }



    public UserResponse updateUserById(UserRequest userRequest) {
        Users user = userRepo.findById(userRequest.getId()).orElseThrow();
        //Users user = new Users();
        user.setName(userRequest.getName());
        user.setUpdatedAt(userRequest.getUpdatedAt());
        user.setAge(userRequest.getAge());
        user.setUpdatedAt(LocalDateTime.now());
        List<Address> addressesInRequest = userRequest.getAddresses().stream().map(city -> {
            return Address.builder()
                    .users(user)
                    .city(city)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
        }).toList();
        List<Address> updatedAddresses = user.getAddresses();//1
        updatedAddresses.addAll(addressesInRequest);//2
        user.setAddresses(updatedAddresses);//2
        Users updatedUser = userRepo.saveAndFlush(user);
        return convertedToUserDto(updatedUser);
    }



    @Override
    public void deleteUser(Integer userId) {
        userRepo.deleteById(userId);
    }
}
