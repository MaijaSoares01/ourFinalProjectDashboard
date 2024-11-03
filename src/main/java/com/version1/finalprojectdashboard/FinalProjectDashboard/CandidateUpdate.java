package com.version1.finalprojectdashboard.FinalProjectDashboard;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CandidateUpdate {
	

	private  CandidateRepository candidateRepository;

	private final CandidateRepository candidateRepository;

	
	@Autowired
	public CandidateUpdate(CandidateRepository candidateRepository) {
		this.candidateRepository = candidateRepository;
	}
	
	// Method to update an existing candidate

	String updateCandidate(Candidate candidate) {
		Optional<Candidate> update = candidateRepository.findById(
				candidate.getCandidateId());
		
		if (update.isEmpty()) {
			return "Candidate not found :( ";
		} else {
			Candidate existingCandidate = update.get();
			existingCandidate.setCandidateName(candidate.getCandidateName());
			existingCandidate.setDegree(candidate.getDegree());
			existingCandidate.setEducation(candidate.getEducation());
			existingCandidate.setGender(candidate.getGender());
			existingCandidate.setGrade(candidate.getGrade());
			existingCandidate.setInterviewScore(candidate.getInterviewScore());
			existingCandidate.setLocation(candidate.getLocation());
			existingCandidate.setProfile(candidate.getProfile());
			existingCandidate.setRejectionStage(candidate.getRejectionStage());
			existingCandidate.setVisaStatus(candidate.getVisaStatus());
			
			 candidateRepository.save(existingCandidate);//Pass the Candidate object
			 return "Candidate updated succesfully.";

	private String updateCandidate(Candidate candidate) {
		Optional<Candidate> update = candidateRepository.findById(
				candidate.getCandidateId());
		if (update == null) {
			return "Candidate not found :( ";
		} else {
			update.get().setCandidate_name(candidate.getCandidate_name());
			update.get().setDegree(candidate.getDegree());
			update.get().setEducation(candidate.getEducation());
			update.get().setGender(candidate.getGender());
			update.get().setGrade(candidate.getGrade());
			update.get().setInterviewScore(candidate.getInterviewScore());
			update.get().setLocation(candidate.getLocation());
			update.get().setProfile(candidate.getProfile());
			update.get().setRejectionStage(candidate.getRejectionStage());
			update.get().setVisaStatus(candidate.getVisaStatus());
			
			return candidateRepository.save(update);

		}
	}

}
