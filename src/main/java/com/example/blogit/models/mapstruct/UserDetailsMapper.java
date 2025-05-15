package com.example.blogit.models.mapstruct;

import com.example.blogit.models.UserDetails;
import com.example.blogit.repository.entity.UserDetailsEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDetailsMapper {
    UserDetails toUserDetails(UserDetailsEntity userDetailsEntity);
    UserDetailsEntity toUserDetailEntity(UserDetails userDetails);
}
