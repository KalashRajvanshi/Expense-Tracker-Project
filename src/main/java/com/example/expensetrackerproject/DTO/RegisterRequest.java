package com.example.expensetrackerproject.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {
    private String username;
    private String password;
    //private String role; // No role here — we’ll set a default role = ROLE_USER in backend when saving.

}
