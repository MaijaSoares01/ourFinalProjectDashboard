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

import com.version1.finalprojectdashboard.FinalProjectDashboard.Candidate;
import com.version1.finalprojectdashboard.FinalProjectDashboard.CandidateService;
import com.version1.finalprojectdashboard.FinalProjectDashboard.JobRoleRepository;


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
		@RequestParam(value = "profile", required = false) String profile,
		@RequestParam(value = "rejectionStage", required = false) String rejectionStage,
		@RequestParam(value = "education", required = false) String education,
		@RequestParam(value = "degree", required = false) String degree,
		@RequestParam(value = "roleApplied", required = false) String roleApplied,
		Model model) {

			List<Candidate> candidates = candidateService.searchCandidates(keyword, gender, visaStatus, 
										profile, rejectionStage, education, degree, roleApplied);
			model.addAttribute("candidates", candidates);

			//add options for the search form
			model.addAttribute("genderOptions", getGenderOptions());
			model.addAttribute("visaStatusOptions", getVisaStatusOptions());
			model.addAttribute("profileOptions", getProfileOptions());
			model.addAttribute("rejectionStageOptions", getRejectionStageOptions());
		    model.addAttribute("educationOptions", getEducationOptions());
		    model.addAttribute("degreeOptions", getDegreeOptions());
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

		return listCandidates(keyword,  gender, visaStatus, profile, rejectionStage, education, degree, roleApplied, model);
	}

	// these are the methods that helps for searching in the form
	private List<String> getVisaStatusOptions() {
		return Arrays.asList("Citizen", "Permanent Resident", "Work Permit", "Student Visa");
	}

	private List<String> getGenderOptions() {
		return Arrays.asList("Male", "Female", "Other");
	}
	
	private List<String> getProfileOptions() {
        return Arrays.asList("Graduate", "Changer", "Returner");
    }
	
	 private List<String> getRejectionStageOptions() {
	        return Arrays.asList("1. In Review",  "2. TIA", "3. Interview", "4.Assessment Day", "5.Offered", "6.Hired");
	    }
	
	 private List<String> getEducationOptions() {
	        return Arrays.asList(
	            "Aberystwyth University",
	            "Aston University",
	            "Bangor University",
	            "Beihang University",
	            "Birmingham City University",
	            "Cardiff Metropolitan University",
	            "Cardiff University",
	            "Comsats University Islamabad",
	            "Coventry University",
	            "Delhi University",
	            "Dublin City University",
	            "Dundalk Institute of Technology",
	            "Durham University",
	            "Edinburgh Napier University",
	            "Institute of Technology Carlow",
	            "Jawaharlal Nehru University",
	            "King’s College London",
	            "Manipal University",
	            "Maynooth University",
	            "National Institute of Technology",
	            "National University of Ireland Galway",
	            "Newcastle University",
	            "Northumbria University",
	            "Paris-Sorbonne University",
	            "Queen's University Belfast",
	            "Sapienza University",
	            "South Tyneside College",
	            "Staffordshire University",
	            "Swansea University",
	            "Technological University Dublin",
	            "Trinity College Dublin",
	            "Ulster University",
	            "University College Birmingham",
	            "University College Cork",
	            "University College Dublin",
	            "University College London",
	            "University of Birmingham",
	            "University of Bordeaux",
	            "University of Brighton",
	            "University of Bristol",
	            "University of Edinburgh",
	            "University of Essex",
	            "University of Exeter",
	            "University of Hertfordshire",
	            "University of Karnataka",
	            "University of Kent",
	            "University of Lancaster",
	            "University of Leeds",
	            "University of Leicester",
	            "University of Liverpool",
	            "University of Manchester",
	            "University of Milan",
	            "University of Mumbai",
	            "University of Newcastle",
	            "University of Nottingham",
	            "University of Oxford Brookes",
	            "University of Peshawar",
	            "University of Pune",
	            "University of Reading",
	            "University of Science and Technology of China",
	            "University of Sheffield",
	            "University of Sheffield Hallam",
	            "University of Southampton",
	            "University of Sunderland",
	            "University of Surrey",
	            "University of Sussex",
	            "University of Wales Trinity Saint David",
	            "University of Warwick",
	            "University of Wolverhampton",
	            "University of York",
	            "Waterford Institute of Technology",
	            "Xiamen University",
	            "Zhejiang University"
	        );
	    }

	    private List<String> getDegreeOptions() {
	        return Arrays.asList(
	            "Applied Mathematics",
	            "Biomedical Engineering",
	            "Civil Engineering",
	            "Computer Science",
	            "Electrical Engineering",
	            "Forensic Science",
	            "Game Development",
	            "Industrial Engineering",
	            "Information Systems",
	            "Information Technology",
	            "Robotics",
	            "Statistics",
	            "Web Development",
	            "Actuarial Science",
	            "Aeronautical Engineering",
	            "Artificial Intelligence",
	            "Astronautical Engineering",
	            "Biology",
	            "Business Information Systems",
	            "Communications",
	            "Computer Graphics",
	            "Control Systems",
	            "Cybersecurity",
	            "Data Science",
	            "Database Management",
	            "Electronics",
	            "Embedded Systems",
	            "Environmental Engineering",
	            "Environmental Geology",
	            "Fluid Mechanics",
	            "IT Management",
	            "Manufacturing Engineering",
	            "Mechanical Design",
	            "Molecular Biology",
	            "Network Administration",
	            "Operations Research",
	            "Power Systems",
	            "Software Engineering",
	            "Structural Engineering",
	            "Systems Analysis and Design",
	            "Systems Engineering"
	        );
	    }
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








