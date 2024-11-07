package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public List<User> searchUsers(String search) {
        return userRepository.findByUsernameOrRoles(search, search);
    }

    public String updateUser(int userId, String username, String password, String roles) {
        // Validate username uniqueness for updates, excluding the current user
        if (userRepository.findByUsername(username).isPresent()) {
            return "redirect:/admin?error=usernameExists";
        }

        User user = userRepository.findById(userId).orElseThrow();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(roles);
        userRepository.save(user);

        return "redirect:/admin";
    }

    public boolean saveUser(User user) {
        // Check if username already exists
        if (userExists(user.getUsername())) {
            throw new IllegalArgumentException("Username already exists.");
        }

        // Check password length
        if (user.getPassword() == null || user.getPassword().length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters.");
        }

        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public boolean createUser(User user) {
        // Check if username already exists
        if (userExists(user.getUsername())) {
            throw new IllegalArgumentException("Username already exists.");
        }

        // Validate password length
        if (user.getPassword().length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters.");
        }

        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save user to repository
        userRepository.save(user);
        return true;
    }

    public String deleteUser(int userId) {
        userRepository.deleteById(userId);
        return "redirect:/admin";
    }

    public boolean userExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public List<User> searchAndFilterUsers(String search, String roleFilter) {
        return userRepository.findByUsernameAndRoles(search, roleFilter);
    }

    public List<User> filterByRole(String roleFilter) {
        return roleFilter == null || roleFilter.isEmpty() ? userRepository.findAll() : userRepository.findByRolesContaining(roleFilter);
    }
}