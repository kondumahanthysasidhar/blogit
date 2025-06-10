package com.example.blogit.models;

import lombok.Data;

@Data
public class UserDetails {

    public Integer userId;

    public String firstName;

    public String lastName;

    public String email;

    public String userName;

    public String phoneNumber;

    public String password;

    public void setPassword(String password) {
        this.password = password;
    }
}
