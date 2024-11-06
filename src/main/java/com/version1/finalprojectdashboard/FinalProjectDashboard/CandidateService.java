package com.version1.finalprojectdashboard.FinalProjectDashboard;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
	
		@Autowired
	    private CandidateRepository candidateRepository;
	 	
		//private CandidateUpdate candidateUpdate;
	 	
		/*
		 * @Autowired public CandidateService(CandidateRepository candidateRepository,
		 * CandidateUpdate candidateUpdate) { this.candidateRepository =
		 * candidateRepository; this.candidateUpdate = candidateUpdate; }
		 */

	    // Get all candidates
	    public List<Candidate> getAllCandidates() {
	        return candidateRepository.findAll();
	    }

	    // Get candidate by ID
	    public Optional<Candidate> getCandidateById(int id) {
	        return candidateRepository.findById(id);
	    }

	    
	 // Add a new candidate
	    public Candidate addCandidate(Candidate candidate) {
	        return candidateRepository.save(candidate);
	    }
	    	    
	    
	    // Update candidate
	    public String updateCandidate(Candidate candidate) {
	    	Optional<Candidate> existingCandidate = CandidateRepository.findById(candidate.getCandidateId());
	        if (existingCandidate.isPresent()) {
	            return CandidateRepository.save(candidate);
	        } else {
	            // Handle the case where the candidate does not exist
	            throw new IllegalArgumentException("Candidate with ID " + candidate.getCandidateId() + " does not exist.");
	        }
	    
	    //  Delete a candidate by their ID
	   public void deleteCandidate(int id) {
		   candidateRepository.deleteById(id);
	   }


	   // Search and filter candidates based on multiple criteria
	    public List<Candidate> searchCandidates(String keyword, String gender, String visaStatus, String profile,
	                                            String rejectionStage, String education, String degree, String roleApplied) {
	        // Start with all candidates
	        List<Candidate> candidates = candidateRepository.findAll();

	        // Apply keyword filter (name or location)
	        if (keyword != null && !keyword.isEmpty()) {
	            String lowerKeyword = keyword.toLowerCase();
	            candidates = candidates.stream()
	                    .filter(c -> c.getCandidateName().toLowerCase().contains(lowerKeyword) ||
	                                 c.getLocation().toLowerCase().contains(lowerKeyword))
	                    .collect(Collectors.toList());
	        }

        // Filter by gender
        if (gender != null && !gender.isEmpty()) {
            candidates = candidates.stream()
                    .filter(c -> c.getGender().equals(gender))
                    .collect(Collectors.toList());
        }

        //fiilter by visa status
        if (visaStatus != null && !visaStatus.isEmpty()) {
            candidates = candidates.stream()
                    .filter(c -> c.getVisaStatus().equals(visaStatus))
                    .collect(Collectors.toList());
        }

        //filter by profile
        if (profile != null && !profile.isEmpty()) {
            candidates = candidates.stream()
                    .filter(c -> c.getProfile().equals(profile))
                    .collect(Collectors.toList());
        }

        // Filter by rejection stage
        if (rejectionStage != null && !rejectionStage.isEmpty()) {
            candidates = candidates.stream()
                    .filter(c -> c.getRejectionStage().equals(rejectionStage))
                    .collect(Collectors.toList());
        }

        // Filter by education
        if (education != null && !education.isEmpty()) {
            candidates = candidates.stream()
                    .filter(c -> c.getEducation().equals(education))
                    .collect(Collectors.toList());
        }

        // Filter by degree
        if (degree != null && !degree.isEmpty()) {
            candidates = candidates.stream()
                    .filter(c -> c.getDegree().equals(degree))
                    .collect(Collectors.toList());
        }

        // Filter by role applied
        if (roleApplied != null && !roleApplied.isEmpty()) {
            candidates = candidates.stream()
                    .filter(c -> c.getRoleApplied() != null
                            && c.getRoleApplied().getJobRoleName().equals(roleApplied))
                    .collect(Collectors.toList());
        }
        return candidates;
	    }

}
