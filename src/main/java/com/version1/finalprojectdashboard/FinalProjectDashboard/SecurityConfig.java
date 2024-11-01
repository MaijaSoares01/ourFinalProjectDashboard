package com.version1.finalprojectdashboard.FinalProjectDashboard;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests( (auth)  -> auth
                        .requestMatchers("/account").authenticated()
                        .requestMatchers("/account/**").authenticated()
                        .requestMatchers("/contact").authenticated()
                        .requestMatchers("/product_management").hasRole("ADMIN")
                        .requestMatchers("/").permitAll()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
//  @Bean
//  public UserDetailsService userDetailsService() {
//      var user = User.withUsername("user")
//              .password("password")
//              .roles("NONEXISTING")
//              .passwordEncoder(NoOpPasswordEncoder.getInstance()::encode)
//              .build();
//      return new InMemoryUserDetailsManager(user);
//  }

//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//		UserDetails user = User.withDefaultPasswordEncoder()
//				.username("Chester")
//				.password("password")
//				.roles("USER")
//				.build();
//		UserDetails admin = User.withDefaultPasswordEncoder()
//				.username("Admin")
//				.password("admin")
//				.roles("ADMIN")
//				.build();
//		return new InMemoryUserDetailsManager(user, admin);
//	}
}
