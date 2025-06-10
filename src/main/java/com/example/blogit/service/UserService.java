package com.example.blogit.service;

import com.example.blogit.models.UserDetails;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDetails getUserDetails(String u);

    @Transactional
    void createUser(final UserDetails userDetails);
}
