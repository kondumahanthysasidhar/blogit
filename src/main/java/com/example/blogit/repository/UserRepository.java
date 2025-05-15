package com.example.blogit.repository;

import com.example.blogit.models.UserDetails;
import com.example.blogit.repository.entity.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetailsEntity, Integer> {
    UserDetailsEntity findByUserName(String userName);
}
