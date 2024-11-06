package com.version1.finalprojectdashboard.FinalProjectDashboard;


import java.util.List;
import java.util.Optional;


import java.util.Optional;

import com.version1.finalprojectdashboard.FinalProjectDashboard.Candidate;
import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.Gender;
import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.VisaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.RejectionStage;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    //degrees, education levels,

	   //find candidates by candidate name containing a keyword
    List<Candidate> findByCandidateNameContainingIgnoreCase(String keyword);
    List<Candidate> findByLocationContainingIgnoreCase(String keyword);
    List<Candidate> findByLocationContaining(String location);
    List<Candidate> findByGender(String gender);
    List<Candidate> findByVisaStatus(String visaStatus);
    List<Candidate> findByProfile(String profile);
    List<Candidate> findByEducation(String education);
    List<Candidate> findByDegree(String degree);
    List<Candidate> findByRejectionStage(String rejectionStage);
    List<Candidate> findByRoleApplied_JobRoleName(String roleApplied);

	// Custom search method using JPQL
	@Query("SELECT c FROM Candidate c WHERE " +
			"(:keyword IS NULL OR :keyword = '' OR LOWER(c.candidateName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(c.location) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND " +
			"(:gender IS NULL OR :gender = '' OR c.gender = :gender) AND " +
			"(:visaStatus IS NULL OR :visaStatus = '' OR c.visaStatus = :visaStatus)")
	List<Candidate> searchCandidates(@Param("keyword") String keyword, @Param("gender") String gender, @Param("visaStatus") String visaStatus);


}

