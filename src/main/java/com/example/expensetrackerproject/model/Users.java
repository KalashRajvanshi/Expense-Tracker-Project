package com.example.expensetrackerproject.model;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")  // we use "users" instead of "user" since "user" is a reserved word in SQL

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Assuming id is a String, you can change it to Long or UUID as needed

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String role;  // Optional field for user roles (e.g., "USER", "ADMIN")



}
