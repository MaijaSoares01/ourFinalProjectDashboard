package com.version1.finalprojectdashboard.FinalProjectDashboard;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class CandidateService {
	
	 @Autowired
	    private CandidateRepository candidateRepository;

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

}
