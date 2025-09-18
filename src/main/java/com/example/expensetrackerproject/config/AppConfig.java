package com.example.expensetrackerproject.config;


import com.example.expensetrackerproject.model.Users;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class AppConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // This method returns a BCryptPasswordEncoder bean for password encoding.
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/register", "/login").permitAll() // public endpoints
//                        .anyRequest().authenticated() // everything else requires login
//                )
//                .httpBasic()   // 👈 Enables API login via Postman
//                .and()
//                .formLogin(form -> form
//                        .loginPage("/login").permitAll() // custom login page
//                        .defaultSuccessUrl("/home", true)    // 👈 force redirect to home after login
//                ).logout(logout -> logout.permitAll());
//
//
//
//        // I have used this when before the use of Thymleaf
////                .formLogin(form -> form
////                        .loginPage("/login.html") // note the .html
////                        .permitAll()
////                )
////                .logout(logout -> logout.permitAll());
//
//        return http.build();

        http
                // Disable CSRF for API testing in Postman. Enable it (or configure properly) for production/Thymeleaf forms.
                .csrf(csrf -> csrf.disable())

                // Authorize requests
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register", "/login").permitAll()
                        .anyRequest().authenticated()
                )

                // Enable Basic auth for API clients (Postman) using the non-deprecated method
                .httpBasic(Customizer.withDefaults())

                // Keep formLogin for browser-based UI (Thymeleaf)
                .formLogin(form -> form
                        .loginPage("/login").permitAll()
                        .defaultSuccessUrl("/expenses/getAllExpenses", true)
                )

                // Logout configuration (lambda style)
                .logout(logout -> logout.permitAll());

        return http.build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/register").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(withDefaults()); // 👈 new style
//
//        return http.build();
//    }


//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails user = User.withUsername("u1")
//                .password(passwordEncoder.encode("12"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
}
