package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
	public List<Candidate> searchCandidates(String keyword, String gender, String visaStatus,
											String profile, String rejectionStage,
											String education, String degree, String roleApplied) {
//
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
