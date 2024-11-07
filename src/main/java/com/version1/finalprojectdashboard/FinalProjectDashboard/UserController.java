package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private CustomUserDetailsManager userDetailsManager;

    @GetMapping("")
    public String showAdminDashboard(
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "roleFilter", required = false) String roleFilter,
            Model model) {

        if (search != null && !search.isEmpty() && roleFilter != null && !roleFilter.isEmpty()) {
            model.addAttribute("users", userService.searchAndFilterUsers(search, roleFilter));
        } else if (search != null && !search.isEmpty()) {
            model.addAttribute("users", userService.searchUsers(search));
        } else if (roleFilter != null && !roleFilter.isEmpty()) {
            model.addAttribute("users", userService.filterByRole(roleFilter));
        } else {
            model.addAttribute("users", userService.getAllUsers());
        }

        model.addAttribute("search", search);
        model.addAttribute("roleFilter", roleFilter);

        return "admin"; // Thymeleaf template
    }

    @PostMapping("/admin/add-user")
    public String addUser(@RequestParam String username, @RequestParam String password,
                          @RequestParam String confirmPassword, @RequestParam String roles,
                          BindingResult result, Model model) {

        boolean hasError = false;

        // Validate required fields (username, password, confirmPassword, and roles)
        if (username == null || username.trim().isEmpty()) {
            model.addAttribute("usernameError", "Username is required.");
            hasError = true;
        }

        if (password == null || password.trim().isEmpty()) {
            model.addAttribute("passwordError", "Password is required.");
            hasError = true;
        } else if (password.length() < 6) {
            model.addAttribute("passwordError", "Password must be at least 6 characters.");
            hasError = true;
        }

        if (confirmPassword == null || confirmPassword.trim().isEmpty()) {
            model.addAttribute("passwordConfirmationError", "Password confirmation is required.");
            hasError = true;
        } else if (!password.equals(confirmPassword)) {
            model.addAttribute("passwordConfirmationError", "Passwords do not match.");
            hasError = true;
        }

        if (roles == null || roles.trim().isEmpty()) {
            model.addAttribute("rolesError", "Roles are required.");
            hasError = true;
        }

        if (hasError) {
            // If there are errors, keep the entered values and return to the admin page
            model.addAttribute("username", username);
            model.addAttribute("roles", roles);
            return "admin";  // Return to the admin page with errors
        }

        // Create the user and save it
        userService.createUser(new User(username, password, true, roles));

        return "redirect:/admin";  // Redirect to the admin page after successful creation
    }


    @PostMapping("/updateUser")
    public String updateUser(
            @RequestParam int userId,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String roles) {
        return userService.updateUser(userId, username, password, roles);
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam int userId) {
        return userService.deleteUser(userId);
    }
}
