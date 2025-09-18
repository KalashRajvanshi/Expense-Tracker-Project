package com.example.expensetrackerproject.service;


import com.example.expensetrackerproject.model.Users;
import com.example.expensetrackerproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

@Service
@RequiredArgsConstructor
//@AllArgsConstructor
public class AuthenticateUserService implements UserDetailsService {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

//    public Users registerUser(RegisterRequest registerRequest){
//
//        String encodedpassword = passwordEncoder.encode(registerRequest.getPassword());
//        Users user = Users.builder()
//                    .username(registerRequest.getUsername())
//                    .password(encodedpassword)
//                    .role("ROLE_USER") // Default role set to ROLE_USER
//                    .build();
//
//        return userRepository.save(user);
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepository.findByUsername(username);
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        if(user==null){
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().replace("ROLE_", "")) // Remove "ROLE_" prefix for roles method
                .build();

    }

}
