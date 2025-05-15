package com.example.blogit.models;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String userName;
    private String password;
}
