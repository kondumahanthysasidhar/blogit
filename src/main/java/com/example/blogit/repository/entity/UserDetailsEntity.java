package com.example.blogit.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "user_details",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "user_name")
        })
@Data
@Getter
public class UserDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public Integer userId;

    @NotBlank(message = "First name is required")
    @Column(name = "first_name")
    public String firstName;

    @NotBlank(message = "Last name is required")
    @Column(name = "last_name")
    public String lastName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Column(name = "email", nullable = false, unique = true)
    public String email;

    @NotBlank(message = "Username is required")
    @Column(name = "user_name", nullable = false, unique = true)
    public String userName;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    @Column(name = "phone_number")
    public String phoneNumber;

    @Column(name = "password")
    public String password;

    public Integer getUserId() {
        return userId;
    }

    public @NotBlank(message = "Username is required") String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
