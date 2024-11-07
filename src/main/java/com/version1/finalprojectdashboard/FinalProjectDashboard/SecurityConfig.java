package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    @Lazy
    private CustomUserDetailsManager customUserDetailsManager;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Configure CSRF - Disable only if necessary for specific routes
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/admin/add-user")) // Ignore CSRF for specific endpoints if needed
                .authorizeRequests(auth -> auth
                        // Define authorization rules
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/dashboard/**", "/associates/**", "/candidates/**", "/jobroles/**", "/tias/**", "/timesheets/**").authenticated()
                        .requestMatchers("/", "/login", "/logout").permitAll()
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // Allow access to static resources
                )
                // Configure form-based login
                .formLogin(form -> form
                        .loginPage("/login") // Custom login page
                        .permitAll()
                        .defaultSuccessUrl("/dashboard", true)
                        .failureUrl("/login?error=true") // Redirect to login with error message on failure
                )
                // Configure logout
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true") // Redirect to login with a success message on logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID") // Clear session cookies on logout
                        .permitAll()
                )
                // Enable HTTP Basic authentication (optional, depending on your needs)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}