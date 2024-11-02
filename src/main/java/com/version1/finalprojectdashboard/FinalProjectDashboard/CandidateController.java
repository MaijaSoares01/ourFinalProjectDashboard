package com.version1.finalprojectdashboard.FinalProjectDashboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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



