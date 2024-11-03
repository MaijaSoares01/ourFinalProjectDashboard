package com.version1.finalprojectdashboard.FinalProjectDashboard;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
	
	
	    private CandidateRepository candidateRepository;
	 	private CandidateUpdate candidateUpdate;
	 	
	 	@Autowired
	 	public CandidateService(CandidateRepository candidateRepository, CandidateUpdate candidateUpdate) {
	 		this.candidateRepository = candidateRepository;
	 		this.candidateUpdate = candidateUpdate;
	 	}

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
	    	return candidateUpdate.updateCandidate(candidate);
	    }
	    
	    //  Delete a candidate by their ID
	   public void deleteCandidate(int id) {
		   candidateRepository.deleteById(id);
	   }

}
