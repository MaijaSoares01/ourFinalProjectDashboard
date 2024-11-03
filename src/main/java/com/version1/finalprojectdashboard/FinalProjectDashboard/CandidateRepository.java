package com.version1.finalprojectdashboard.FinalProjectDashboard;


import java.util.List;
import java.util.Optional;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.RejectionStage;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer>{


	String save(Optional<Candidate> update);
	
	List<Candidate> findByInterviewScoreGreaterThanEqual(Integer score);
	List<Candidate> findByRejectionStage(RejectionStage rejectionStage);
		

}


