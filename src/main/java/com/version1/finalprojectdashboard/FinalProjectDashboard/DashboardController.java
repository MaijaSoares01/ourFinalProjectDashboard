package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
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
}
