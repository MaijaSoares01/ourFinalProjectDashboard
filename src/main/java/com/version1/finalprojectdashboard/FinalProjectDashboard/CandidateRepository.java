package com.version1.finalprojectdashboard.FinalProjectDashboard;

<<<<<<< Updated upstream
=======
import java.util.List;
import java.util.Optional;

>>>>>>> Stashed changes
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.RejectionStage;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer>{
<<<<<<< Updated upstream
	
=======
>>>>>>> Stashed changes
	
	List<Candidate> findByInterviewScoreGreaterThanEqual(Integer score);
	List<Candidate> findByRejectionStage(RejectionStage rejectionStage);
		

}


