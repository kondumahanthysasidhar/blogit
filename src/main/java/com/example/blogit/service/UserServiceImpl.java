package com.example.blogit.service;

import com.example.blogit.models.UserDetails;
import com.example.blogit.models.mapstruct.UserDetailsMapper;
import com.example.blogit.repository.UserRepository;
import com.example.blogit.repository.entity.UserDetailsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserRepository userRepository;
    private UserDetailsMapper userDetailsMapper;
    UserServiceImpl(UserRepository userRepository, UserDetailsMapper userDetailsMapper){
        this.userRepository = userRepository;
        this.userDetailsMapper = userDetailsMapper;
    }
    @Override
    public UserDetails getUserDetails(String userName) {
        logger.info("Inside Service Layer UserServiceImpl::getUserDetails");
        UserDetailsEntity u = userRepository.findByUserName(userName);
        return userDetailsMapper.toUserDetails(u);
    }

    @Override
    public void createUser(final UserDetails userDetails){
        UserDetailsEntity userDetailsEntity = userDetailsMapper.toUserDetailEntity(userDetails);
        userRepository.save(userDetailsEntity);
    }
}
