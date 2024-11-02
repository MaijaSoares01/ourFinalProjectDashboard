package com.version1.finalprojectdashboard.FinalProjectDashboard;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer>{

	String save(Optional<Candidate> update);
	
	

}


