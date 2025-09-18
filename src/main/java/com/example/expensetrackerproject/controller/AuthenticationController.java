package com.example.expensetrackerproject.controller;

//import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;
import com.example.expensetrackerproject.DTO.RegisterRequest;
import com.example.expensetrackerproject.model.Users;
import com.example.expensetrackerproject.repository.UserRepository;
import com.example.expensetrackerproject.service.AuthenticateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
//@RequestMapping("api/auth")
@RequiredArgsConstructor

public class AuthenticationController {

    private final AuthenticateUserService authenticateUserService;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());
        return "register"; // return the name of the registration view (e.g., register.html
    }


    @PostMapping("/register")
    public String processRegister(@ModelAttribute Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // encrypt password
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // return the name of the login view (e.g., login.html
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}
