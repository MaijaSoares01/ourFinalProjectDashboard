package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        // Add any attributes you might need to display on the login page
        return "login"; // This returns the "login.html" Thymeleaf template
    }

    @GetMapping("/")
    public String showLogin(Model model) {
        return "redirect:/login";
    }

    @GetMapping("/login?error=true")
    public String loginError(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("errorMessage", "Invalid username or password.");
        return "redirect:/login";
    }
}
