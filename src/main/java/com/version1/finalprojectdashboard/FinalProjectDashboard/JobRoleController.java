package com.version1.finalprojectdashboard.FinalProjectDashboard;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller for handling requests with JobRole objects

@Controller
@RequestMapping("/jobroles") 
public class JobRoleController{
	
	
	
	// Service layer for the jobRoles
	@Autowired
	private  JobRoleService jobRoleService;

    // Injecting JobRoleUpdate component to handle updates
	@Autowired
    private  JobRoleUpdate jobRoleUpdate;
	
	
	
	// Displays the list of all jobRoles
	@GetMapping 
	public String listJobRoles(Model model) {
		List<JobRole> jobRoles = jobRoleService.getAllJobRoles();
		model.addAttribute("jobRoles",jobRoles);// 
		return "jobroles/list"; // this is the html template for adding jobRole
	}
	
	// Method to handle the form submission for adding a new one
	@GetMapping("/add")
	 public String showAddJobRoleForm(Model model) {
        model.addAttribute("jobRole", new JobRole()); // Add empty JobRole object for form
        return "jobroles/add"; // 
    }
	
	   // Method to handle form submission for adding a new JobRole
    @PostMapping("/add")
    public String addJobRole(@ModelAttribute JobRole jobRole, Model model) {
        jobRoleService.addJobRole(jobRole); // Save JobRole to database
        return "redirect:/jobroles"; // Redirect to list after adding
    }
	
	// Method to show form to edit an existing JobRole
    @GetMapping("/edit/{id}")
    public String showEditJobRoleForm(@PathVariable int id, Model model) {
        Optional<JobRole> jobRoleOptional = jobRoleService.getJobRoleById(id); // Find JobRole by ID

        if (jobRoleOptional.isPresent()) {
            JobRole jobRole = jobRoleOptional.get();
            model.addAttribute("jobRole", jobRole); // Add JobRole to model for form
            return "jobroles/edit"; 
        } else {
            return "error/404"; 
        }
    }

    // Method to handle form submission for editing a JobRole
    @PostMapping("/edit/{id}")
    public String editJobRole(@PathVariable int id, @ModelAttribute JobRole jobRole, Model model) {
        jobRole.setJobRoleId(id); // Set the ID to ensure correct JobRole is updated
        String updateMessage = jobRoleUpdate.updateJobRole(jobRole); // Update JobRole
        return "redirect:/jobroles"; // Redirect to list after editing
    }

    // Method to handle deletion of a JobRole
    @PostMapping("/delete/{id}")
    public String deleteJobRole(@PathVariable int id, Model model) {
        jobRoleService.deleteJobRole(id); // Delete JobRole by ID
        return "redirect:/jobroles"; // Redirect to list after deletion
    }
}
