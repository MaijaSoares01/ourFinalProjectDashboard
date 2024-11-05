package com.version1.finalprojectdashboard.FinalProjectDashboard;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Autowired
	private CustomUserDetailsManager customUserDetailsManager;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(4);
    }

	// Security filter chain configuration
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/account", "/account/**", "/contact", "/candidates", "/candidates/**", "/jobroles", "/jobroles/**").authenticated()
						.requestMatchers("/product_management").hasRole("ADMIN")
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.requestMatchers("/dashboard/**").authenticated()
						.requestMatchers("/show-all-associates").authenticated()
						.requestMatchers("/showtias").authenticated()
						.requestMatchers("/").permitAll()
				)
				.formLogin(form -> form
						.loginPage("/login") // Point to custom login page
						.permitAll()
						.defaultSuccessUrl("/dashboard", true)
						.failureUrl("/login?error=true") // Optionally, handle login errors
				)
				.logout(logout -> logout.permitAll());

		return http.build();
	}
    
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests( (auth)  -> auth
//                        .requestMatchers("/account").authenticated()
//                        .requestMatchers("/account/**").authenticated()
//                        .requestMatchers("/contact").authenticated()
//                        .requestMatchers("/product_management").hasRole("ADMIN")
//                        .requestMatchers("/candidates").authenticated()
//                        .requestMatchers("/candidates/**").authenticated()
//                        .requestMatchers("/jobroles").authenticated()
//                        .requestMatchers("/jobroles/**").authenticated()
//                        .requestMatchers("/").permitAll()
//                )
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
    
	/*
	 * @Bean public InMemoryUserDetailsManager
	 * userDetailsManager(BCryptPasswordEncoder passwordEncoder) { UserDetails user
	 * = User.builder() .username("user")
	 * .password(passwordEncoder.encode("password")) .roles("USER") .build();
	 * 
	 * UserDetails admin = User.builder() .username("admin")
	 * .password(passwordEncoder.encode("admin")) .roles("ADMIN") .build();
	 * 
	 * return new InMemoryUserDetailsManager(user, admin);
	 * 
	 * }
	 */

    
//  @Bean
//  public UserDetailsService userDetailsService() {
//      var user = User.withUsername("user")
//              .password("password")
//              .roles("NONEXISTING")
//              .passwordEncoder(NoOpPasswordEncoder.getInstance()::encode)
//              .build();
//      return new InMemoryUserDetailsManager(user);
//  }


}
