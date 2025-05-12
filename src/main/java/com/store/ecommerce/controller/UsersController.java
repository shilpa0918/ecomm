package com.store.ecommerce.controller;

import com.store.ecommerce.request.UserRequest;
import com.store.ecommerce.respose.UserResponse;
import com.store.ecommerce.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/v1")
public class UsersController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.addUser(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> userResponses = userService.getAllUsers();
        return new ResponseEntity<>(userResponses, HttpStatus.OK);
    }

    @GetMapping("/getUserByName/{userName}")
    public ResponseEntity<UserResponse> getUserByName(@PathVariable String userName) {
        UserResponse userResponse = userService.getUserByName(userName);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }


    @PutMapping("/updateUserById")
    public ResponseEntity<UserResponse> updateUserById(@RequestBody UserRequest userRequest){
        UserResponse userResponse = userService.updateUserById(userRequest);
        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity deleteUser(@PathVariable Integer userId){
        userService.deleteUser(userId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
