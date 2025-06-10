package com.example.blogit.config;

import com.example.blogit.repository.UserRepository;
import com.example.blogit.repository.entity.UserDetailsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsEntity user = Optional.ofNullable(userRepository.findByUserName(username)).orElseThrow(
                () -> new UsernameNotFoundException("User not found"));
        return User.builder()
                .username(user.getUserName())
                .password(user.getPassword())  // Make sure this is encoded!
                .build();
    }
}
