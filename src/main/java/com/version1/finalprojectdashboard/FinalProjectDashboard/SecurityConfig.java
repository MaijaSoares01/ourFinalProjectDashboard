package com.version1.finalprojectdashboard.FinalProjectDashboard;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		UserDetails user = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
//				.username("cae")
//				.password("cae")
//				.roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(user);
//	}

	@Autowired
	private CustomUserDetailsManager customUserDetailsManager;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(4);
    }

	// Security filter chain configuration
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeRequests((auth) -> {
					try {
						auth
								.requestMatchers("/account", "/account/**", "/contact", "/candidates", "/candidates/**", "/jobroles", "/jobroles/**").authenticated()
								.requestMatchers("/admin/**").hasRole("ADMIN")
								.requestMatchers("/dashboard/**").authenticated()
								.requestMatchers("/").permitAll()
								.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
								.and()
								.formLogin(form -> form
										.loginPage("/login") // Point to custom login page
										.permitAll()
										.defaultSuccessUrl("/dashboard", true)
										.failureUrl("/login?error=true") // Optionally, handle login errors
								)
								.logout(logout -> logout
										.logoutSuccessUrl("/login?logout") // Redirect after logout
										.invalidateHttpSession(true)
										.clearAuthentication(true)
										.deleteCookies("JSESSIONID") // Clears session cookies
										.permitAll()
								);
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
	).httpBasic(Customizer.withDefaults());
	return http.build();
}

}
