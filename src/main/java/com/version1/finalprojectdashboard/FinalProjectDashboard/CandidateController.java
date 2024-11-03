package com.version1.finalprojectdashboard.FinalProjectDashboard;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.Gender;
import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.Profile;
import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.RejectionStage;
import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.VisaStatus;


@Controller
@RequestMapping("/candidates")
public class CandidateController {


	@Autowired
	private CandidateService candidateService;



	// Display the list of all candidates
	@GetMapping
	public String listCandidates(Model model) {
		model.addAttribute("candidates", candidateService.getAllCandidates());
		return "candidates/list";
	}



	//Display the form to add a new candidate
	@GetMapping("/add")
	public String showAddCandidateForm(Model model) {
		model.addAttribute("candidate", new Candidate());
		model.addAttribute("genders", Gender.values());
		model.addAttribute("profiles", Profile.values());
		model.addAttribute("visaStatuses", VisaStatus.values());
		model.addAttribute("rejectionStages", RejectionStage.values());
		//model.addAttribute("jobRoles", jobRoleService.getAllJobRoles());
		return "candidates/add";
	}

	// Manages the Submission of the candidate
	@PostMapping("/add")
	public String addCandidate(@ModelAttribute Candidate candidate, Model model) {
	    candidateService.addCandidate(candidate);
	    return "redirect:/candidates";
	}


	
	

	//Form to edit an existing candidate
	@GetMapping("/edit/{id}")
	public String showEditCandidateForm(@PathVariable Integer id, Model model) {
		// Get the cnadidate by ID
		Optional<Candidate> optionalCandidate = candidateService.getCandidateById(id);
		//Id the candidate is found
		if(optionalCandidate.isPresent()) {
			Candidate candidate = optionalCandidate.get();
			// Add candidate and other data to the model for rendering the edit form
			model.addAttribute("candidate", candidate);
			model.addAttribute("genders", Gender.values());
			model.addAttribute("profiles", Profile.values());
			model.addAttribute("visaStatuses", VisaStatus.values());
			model.addAttribute("rejectionStages", RejectionStage.values());
			//model.addAttribute("jobRoles", jobRoleService.getAllJobRoles());
			return "candidates/edit";
		}else {
			return "error/404";
		}

	}
	
	//Handles the submission of an edited candidate
	@PostMapping("/edit/{id}")
	public String editCandidate(@PathVariable Integer id, @ModelAttribute Candidate candidate) {
	    candidate.setCandidateId(id);
	    candidateService.updateCandidate(candidate);
	    return "redirect:/candidates";
	}



	//Delete
	@PostMapping("/delete/{id}")
	public String deleteCandidate(@PathVariable int id) {
		candidateService.deleteCandidate(id);
		return "redirect:/candidates";
	}


@RestController

public class CandidateController {

		
		private final CandidateService candidateService;
		
		@Autowired
		public CandidateController(CandidateService candidateService) {
			this.candidateService = candidateService;
		}
		
		
		// GetMapping > basic webpage (returns a message)
		@GetMapping("/")
		public String welcome() {
			return "Welcome to the Candidate Dashboard";
		}
		

		@GetMapping("/all")
		public String getAllCandidates(Model model) {
			List<Candidate> candidates = candidateService.getAllCandidates();
			model.addAttribute("Candidates", candidates);
			return "candidates";
		}
		
		//Adding a new candidate
		@PostMapping("/add-candidate")
		public String addCandidate(@ModelAttribute Candidate candidate) {
			candidateService.addCandidate(candidate);
			return "redirect:/candidates";
		}



}



