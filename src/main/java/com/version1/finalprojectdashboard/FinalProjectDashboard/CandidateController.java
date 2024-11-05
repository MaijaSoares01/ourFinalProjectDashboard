package com.version1.finalprojectdashboard.FinalProjectDashboard;

import java.util.Arrays;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.Gender;
import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.Profile;
import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.RejectionStage;
import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.VisaStatus;


@Controller
//@RequestMapping("/candidates")
public class CandidateController {


	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private JobRoleRepository jobRoleRepository;



	// Display the list of all candidates
	@GetMapping("/candidates")
	public String listCandidates (
		@RequestParam(value = "keyword", required = false) String keyword,
		@RequestParam(value = "gender", required = false) String gender,
		@RequestParam(value = "visaStatus", required = false) String visaStatus,
		Model model) {

			List<Candidate> candidates = candidateService.searchCandidates(keyword, gender, visaStatus);
			model.addAttribute("candidates", candidates);

			// Add options for the search form
			model.addAttribute("genderOptions", getGenderOptions());
			model.addAttribute("visaStatusOptions", getVisaStatusOptions());

		// Add the current search criteria to the model
		model.addAttribute("selectedGender", gender);
		model.addAttribute("selectedVisaStatus", visaStatus);
		model.addAttribute("keyword", keyword);

			return "list";
		}

	private List<String> getVisaStatusOptions() {
		return Arrays.asList("Citizen", "Permanent Resident", "Work Permit", "Student Visa");
	}

	private List<String> getGenderOptions() {
		return Arrays.asList("Male", "Female", "Other");
	}

	// Handle the search form submission
	@GetMapping("/candidates/search")
	public String searchCandidates(
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "visaStatus", required = false) String visaStatus,
			Model model) {

		return listCandidates(keyword, gender, visaStatus, model);
	}











//	//Display the form to add a new candidate
//	@GetMapping("/add")
//	public String showAddCandidateForm(Model model) {
//		model.addAttribute("candidate", new Candidate());
//		model.addAttribute("genders", Gender.values());
//		model.addAttribute("profiles", Profile.values());
//		model.addAttribute("visaStatuses", VisaStatus.values());
//		model.addAttribute("rejectionStages", RejectionStage.values());
//		model.addAttribute("jobRoles", jobRoleRepository.findAll());
//		return "candidates/add";
//	}

//	// Manages the Submission of the candidate
//	@PostMapping("/add")
//	public String addCandidate(@ModelAttribute Candidate candidate, Model model) {
//	    candidateService.addCandidate(candidate);
//	    return "redirect:/candidates";
//	}


	
	

//	//Form to edit an existing candidate
//	@GetMapping("/edit/{id}")
//	public String showEditCandidateForm(@PathVariable Integer id, Model model) {
//		// Get the cnadidate by ID
//		Optional<Candidate> optionalCandidate = candidateService.getCandidateById(id);
//		//Id the candidate is found
//		if(optionalCandidate.isPresent()) {
//			Candidate candidate = optionalCandidate.get();
//			// Add candidate and other data to the model for rendering the edit form
//			model.addAttribute("candidate", candidate);
//			model.addAttribute("genders", Gender.values());
//			model.addAttribute("profiles", Profile.values());
//			model.addAttribute("visaStatuses", VisaStatus.values());
//			model.addAttribute("rejectionStages", RejectionStage.values());
//			model.addAttribute("jobRoles", jobRoleRepository.findAll());
//			return "candidates/edit";
//		}else {
//			return "error/404";
//		}
//
//	}
	
//	//Handles the submission of an edited candidate
//	@PostMapping("/edit/{id}")
//	public String editCandidate(@PathVariable Integer id, @ModelAttribute Candidate candidate) {
//	    candidate.setCandidateId(id);
//	    candidateService.updateCandidate(candidate);
//	    return "redirect:/candidates";
//	}



//	//Delete
//	@PostMapping("/delete/{id}")
//	public String deleteCandidate(@PathVariable int id) {
//		candidateService.deleteCandidate(id);
//		return "redirect:/candidates";
//	}




}



