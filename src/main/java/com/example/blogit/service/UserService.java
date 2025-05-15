package com.example.blogit.service;

import com.example.blogit.models.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDetails getUserDetails(String u);

    void createUser(final UserDetails userDetails);
}
