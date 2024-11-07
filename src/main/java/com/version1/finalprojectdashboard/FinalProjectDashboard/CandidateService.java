package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidateService{


	private CandidateRepository candidateRepository;


	@Autowired
	public CandidateService(CandidateRepository candidateRepository) {
		this.candidateRepository = candidateRepository;
	}


	// Get all candidates
	public List<Candidate> getAllCandidates() {
		return candidateRepository.findAll();
	}

	// Get candidate by ID
	public Optional<Candidate> getCandidateById(int id) {
		return candidateRepository.findById(id);
	}


	// Search and filter candidates based on multiple criteria
	public List<Candidate> searchCandidates(String keyword, String gender, String visaStatus, String profile,
											String rejectionStage, String education, String degree, String roleApplied) {
//		// Start with all candidates
//		List<Candidate> candidates = candidateRepository.findAll();
//
//		// Apply keyword filter (name or location)
//		if (keyword != null && !keyword.isEmpty()) {
//			String lowerKeyword = keyword.toLowerCase();
//			candidates = candidates.stream()
//					.filter(c -> c.getCandidateName().toLowerCase().contains(lowerKeyword) ||
//							c.getLocation().toLowerCase().contains(lowerKeyword))
//					.collect(Collectors.toList());
//		}
//
//		// Filter by gender
//		if (gender != null && !gender.isEmpty()) {
//			candidates = candidates.stream()
//					.filter(c -> c.getGender().equals(gender))
//					.collect(Collectors.toList());
//		}
//
//		//fiilter by visa status
//		if (visaStatus != null && !visaStatus.isEmpty()) {
//			candidates = candidates.stream()
//					.filter(c -> c.getVisaStatus().equals(visaStatus))
//					.collect(Collectors.toList());
//		}
//
//		//filter by profile
//		if (profile != null && !profile.isEmpty()) {
//			candidates = candidates.stream()
//					.filter(c -> c.getProfile().equals(profile))
//					.collect(Collectors.toList());
//		}
//
//		// Filter by rejection stage
//		if (rejectionStage != null && !rejectionStage.isEmpty()) {
//			candidates = candidates.stream()
//					.filter(c -> c.getRejectionStage().equals(rejectionStage))
//					.collect(Collectors.toList());
//		}
//
//		// Filter by education
//		if (education != null && !education.isEmpty()) {
//			candidates = candidates.stream()
//					.filter(c -> c.getEducation().equals(education))
//					.collect(Collectors.toList());
//		}
//
//		// Filter by degree
//		if (degree != null && !degree.isEmpty()) {
//			candidates = candidates.stream()
//					.filter(c -> c.getDegree().equals(degree))
//					.collect(Collectors.toList());
//		}
//
//		// Filter by role applied
//		if (roleApplied != null && !roleApplied.isEmpty()) {
//			candidates = candidates.stream()
//					.filter(c -> c.getRoleApplied() != null
//							&& c.getRoleApplied().getJobRoleName().equals(roleApplied))
//					.collect(Collectors.toList());
//		}
		return  candidateRepository.searchCandidates(keyword, gender, visaStatus, profile, rejectionStage, education, degree, roleApplied);
	}
	public List<String> getDistinctGenders() {
		return candidateRepository.findDistinctGenders();
	}

	public List<String> getDistinctVisaStatuses() {
		return candidateRepository.findDistinctVisaStatuses();
	}

	public List<String> getDistinctProfiles() {
		return candidateRepository.findDistinctProfiles();
	}

	public List<String> getDistinctRejectionStages() {
		return candidateRepository.findDistinctRejectionStages();
	}

	public List<String> getDistinctEducations() {
		return candidateRepository.findDistinctEducations();
	}

	public List<String> getDistinctDegrees() {
		return candidateRepository.findDistinctDegrees();
	}

	public List<String> getDistinctRoleApplieds() {
		return candidateRepository.findDistinctRoleApplieds();
	}


}
