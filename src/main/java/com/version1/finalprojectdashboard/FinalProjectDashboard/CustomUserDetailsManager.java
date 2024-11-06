package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsManager implements UserDetailsManager {

    @Autowired
    private UserRepository userRepo;


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

    @Override
    public void createUser(UserDetails user) {
        // Convert UserDetails back to your User entity and save it
//        User newUser = new User();
//        newUser.setUsername(user.getUsername());
//        newUser.setPassword(user.getPassword()); // You might want to encode this password
//        newUser.setActive(true); // You might want to set active status based on some condition
//        // Set roles if any
//        // newUser.setRoles(...); // Handle roles accordingly
//        userRepo.save(newUser);
    }

    @Override
    public void updateUser(UserDetails user) {
        // Find existing user and update it
//        User existingUser = userRepo.findByUsername(user.getUsername())
//                .orElseThrow(() -> new UsernameNotFoundException("Couldn't find the user: " + user.getUsername()));
//
//        existingUser.setPassword(user.getPassword()); // You might want to encode this password
//        // Update other fields as necessary
//        userRepo.save(existingUser);
    }

    @Override
    public void deleteUser(String username) {
        //userRepo.deleteByUsername(username); // Ensure your repository has this method
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        // This method would be responsible for changing the password
        // Find user by old password, then update the password
        // You might need to verify the old password first
    }

    @Override
    public boolean userExists(String username) {
        return userRepo.findByUsername(username).isPresent();
    }
}
