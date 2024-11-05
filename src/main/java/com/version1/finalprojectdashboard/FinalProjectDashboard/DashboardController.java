package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
    @GetMapping
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminDashboard() {
        return "admin-dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            // User is logged in
            model.addAttribute("username", auth.getName());
            return "dashboard"; // Return your dashboard view
        }
        return "redirect:/login"; // Redirect to login if not authenticated
    }
}
//package com.version1.finalprojectdashboard.FinalProjectDashboard;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class DashboardController {
//
//    @GetMapping("/dashboard")
//    public String showDashboard(Model model) {
//        // Retrieve the currently authenticated user
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String username = auth.getName(); // Gets the username of the authenticated user
//
//        // Add the username to the model
//        model.addAttribute("username", username);
//
//        return "dashboard"; // Returns the "dashboard.html" Thymeleaf template
//    }
//}
