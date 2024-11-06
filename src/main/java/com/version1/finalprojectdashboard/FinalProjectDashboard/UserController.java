package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    //@PreAuthorize("hasRole('admin')")

    @GetMapping("/admin")
    public String adminDashboard(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // User is logged in
        if (auth != null && auth.isAuthenticated()) {
            List<User> users = userService.getAllUsers();
            model.addAttribute("users", users);
//            model.addAttribute("loggeduser", auth.getPrincipal());
            return "admin"; // Return your dashboard view
        }
        return  "admin";
    }

//    @GetMapping("/{id}")
//    public Optional<User> getUserById(@PathVariable int id) {
//        return userService.getUserById(id);
//    }

}
