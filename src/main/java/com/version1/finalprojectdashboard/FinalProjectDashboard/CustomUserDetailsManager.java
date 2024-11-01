package com.version1.finalprojectdashboard.FinalProjectDashboard;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsManager implements UserDetailsManager {

    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> u = userRepo.findByUsername(username);
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Couldn't find the user: " + username));
    }

    @Override
    public void createUser(UserDetails user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateUser(UserDetails user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteUser(String username) {
        // TODO Auto-generated method stub

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean userExists(String username) {
        // TODO Auto-generated method stub
        return false;
    }



}
