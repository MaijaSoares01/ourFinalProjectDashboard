package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsManager implements UserDetailsManager {

    @Autowired
    private UserRepository userRepo;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public CustomUserDetailsManager(UserRepository userRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user by username
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Couldn't find the user: " + username));

        // Convert User to UserDetails
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .disabled(!user.isActive()) // if user is not active, set disabled to true
                .accountExpired(false)
                .credentialsExpired(false)
                .accountLocked(false)
                .roles(user.getRoles()) // convert roles to String array
                .build();
    }


    public boolean createUser(User user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword())); // Encode the password
        newUser.setActive(true); // Set default active status; customize if needed

        // Assuming `userDetails.getAuthorities()` provides the roles
        String roles = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .reduce((a, b) -> a + "," + b) // Convert list to comma-separated string
                .orElse("");
        newUser.setRoles(roles);

        userRepo.save(newUser);
        return true;
    }

    @Override
    public void createUser(UserDetails user) {

    }

    @Override
    public void updateUser(UserDetails userDetails) {
        User existingUser = userRepo.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Couldn't find the user: " + userDetails.getUsername()));

        existingUser.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        existingUser.setRoles(userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .reduce((a, b) -> a + "," + b)
                .orElse(""));

        userRepo.save(existingUser);
    }

    @Override
    public void deleteUser(String username) {
        userRepo.findByUsername(username).ifPresent(userRepo::delete);
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        // Optional: implement password change logic
    }

    @Override
    public boolean userExists(String username) {
        return userRepo.findByUsername(username).isPresent();
    }
}
