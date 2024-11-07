package com.version1.finalprojectdashboard.FinalProjectDashboard;

import java.util.Arrays;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class CandidateController {

	private CandidateService candidateService;
	private JobRoleRepository jobRoleRepository;

	@Autowired
	public CandidateController(CandidateService candidateService, JobRoleRepository jobRoleRepository) {
		this.candidateService = candidateService;
		this.jobRoleRepository = jobRoleRepository;
	}

//	@Autowired
//	private CandidateService candidateService;
//
//	@Autowired
//	private JobRoleRepository jobRoleRepository;


	// Display the list of all candidates
	@GetMapping("/candidates")
	public String listCandidates(
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "visaStatus", required = false) String visaStatus,
			@RequestParam(value = "profile", required = false) String profile,
			@RequestParam(value = "rejectionStage", required = false) String rejectionStage,
			@RequestParam(value = "education", required = false) String education,
			@RequestParam(value = "degree", required = false) String degree,
			@RequestParam(value = "roleApplied", required = false) String roleApplied,
			Model model) {

		List<Candidate> candidates = candidateService.searchCandidates(keyword, gender, visaStatus,
				profile, rejectionStage, education, degree, roleApplied);
		model.addAttribute("candidates", candidates);

		// Disticnt options for dropdowns from DB
		List<String> genderOptions = candidateService.getDistinctGenders();
		List<String> visaStatusOptions = candidateService.getDistinctVisaStatuses();
		List<String> profileOptions = candidateService.getDistinctProfiles();
		List<String> rejectionStageOptions = candidateService.getDistinctRejectionStages();
		List<String> educationOptions = candidateService.getDistinctEducations();
		List<String> degreeOptions = candidateService.getDistinctDegrees();
		List<String> roleOptions = candidateService.getDistinctRoleApplieds();

		//add options for the search form
		model.addAttribute("genderOptions", genderOptions);
		model.addAttribute("visaStatusOptions", visaStatusOptions);
		model.addAttribute("profileOptions", profileOptions);
		model.addAttribute("rejectionStageOptions", rejectionStageOptions);
		model.addAttribute("educationOptions", educationOptions);
		model.addAttribute("degreeOptions", degreeOptions);
		model.addAttribute("roleOptions", roleOptions);
		model.addAttribute("roleOptions", jobRoleRepository.findAll());

		//Add the current search criteria to the model
		model.addAttribute("selectedGender", gender);
		model.addAttribute("selectedVisaStatus", visaStatus);
		model.addAttribute("selectedProfile", profile);
		model.addAttribute("selectedRejectionStage", rejectionStage);
		model.addAttribute("selectedEducation", education);
		model.addAttribute("selectedDegree", degree);
		model.addAttribute("selectedRoleApplied", roleApplied);
		model.addAttribute("keyword", keyword);

		if (candidates.isEmpty()) {
			model.addAttribute("message", "No candidates found matching your criteria.");
		}

		return "list";
	}

	// managin the search form submission
	@GetMapping("/candidates/search")
	public String searchCandidates(
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "visaStatus", required = false) String visaStatus,
			@RequestParam(value = "profile", required = false) String profile,
			@RequestParam(value = "rejectionStage", required = false) String rejectionStage,
			@RequestParam(value = "education", required = false) String education,
			@RequestParam(value = "degree", required = false) String degree,
			@RequestParam(value = "roleApplied", required = false) String roleApplied,
			Model model) {

		return listCandidates(keyword, gender, visaStatus, profile, rejectionStage, education, degree, roleApplied, model);
	}
}







