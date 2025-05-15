package com.example.blogit.controller;

import com.example.blogit.models.UserDetails;
import com.example.blogit.models.UserLoginRequest;
import com.example.blogit.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/blogit/login")
    private Object login(@RequestBody final UserLoginRequest userLoginRequest){
        logger.info("inside login controller");
        return null;
    }
    @GetMapping(value = "/blogit/userdetails/")
    private UserDetails userDetails(@RequestParam(value = "username",
    required = true) final String userName){
        logger.info("in Get UserDetails");
        return userService.getUserDetails(userName);

    }

    @PostMapping(value = "/blogit/userdetails/")
    private Object createUserDetails(@RequestBody final UserDetails userDetails){
        logger.info("in Post UserDetails");
        userService.createUser(userDetails);
        return null;
    }
}
