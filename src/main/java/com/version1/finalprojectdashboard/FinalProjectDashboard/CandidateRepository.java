package com.version1.finalprojectdashboard.FinalProjectDashboard;


import java.util.List;
import java.util.Optional;


import java.util.Optional;

import com.version1.finalprojectdashboard.FinalProjectDashboard.Candidate;
import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.Gender;
import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.VisaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.RejectionStage;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {


// Queries to retrieve the values from the DB and display them in the dropdown menu
    @Query("SELECT DISTINCT c.gender FROM Candidate c")
    List<String> findDistinctGenders();


    @Query("SELECT DISTINCT c.visaStatus FROM Candidate c ORDER BY c.visaStatus ASC")
    List<String> findDistinctVisaStatuses();

    @Query("SELECT DISTINCT c.profile FROM Candidate c ORDER BY c.profile ASC")
    List<String> findDistinctProfiles();

    @Query("SELECT DISTINCT c.rejectionStage FROM Candidate c ORDER BY c.rejectionStage ASC")
    List<String> findDistinctRejectionStages();

    @Query("SELECT DISTINCT c.education FROM Candidate c ORDER BY c.education ASC")
    List<String> findDistinctEducations();

    @Query("SELECT DISTINCT c.degree FROM Candidate c ORDER BY c.degree ASC")
=======
    @Query("SELECT DISTINCT c.visaStatus FROM Candidate c ORDER BY c.visaStatus ASC ")
    List<String> findDistinctVisaStatuses();

    @Query("SELECT DISTINCT c.profile FROM Candidate c ORDER BY c.profile ASC")
    List<String> findDistinctProfiles();

    @Query("SELECT DISTINCT c.rejectionStage FROM Candidate c ORDER BY c.rejectionStage ASC")
    List<String> findDistinctRejectionStages();

    @Query("SELECT DISTINCT c.education FROM Candidate c ORDER BY c.education ASC")
    List<String> findDistinctEducations();

    @Query("SELECT DISTINCT c.degree FROM Candidate c ORDER BY c.degree ASC")

    List<String> findDistinctDegrees();

    @Query("SELECT DISTINCT c.roleApplied.jobRoleName FROM Candidate c")
    List<String> findDistinctRoleApplieds();
	// Custom search method using JPQL

    // Methood with all the filters
        @Query("SELECT c FROM Candidate c WHERE " +
                "(:keyword IS NULL OR :keyword = '' OR LOWER(c.candidateName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(c.location) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND " +
                "(:gender IS NULL OR :gender = '' OR LOWER(c.gender) = LOWER(:gender)) AND " +
                "(:visaStatus IS NULL OR :visaStatus = '' OR LOWER(c.visaStatus) = LOWER(:visaStatus)) AND " +
                "(:profile IS NULL OR :profile = '' OR LOWER(c.profile) = LOWER(:profile)) AND " +
                "(:rejectionStage IS NULL OR :rejectionStage = '' OR LOWER(c.rejectionStage) = LOWER(:rejectionStage)) AND " +
                "(:education IS NULL OR :education = '' OR LOWER(c.education) = LOWER(:education)) AND " +
                "(:degree IS NULL OR :degree = '' OR LOWER(c.degree) = LOWER(:degree)) AND " +
                "(:roleApplied IS NULL OR :roleApplied = '' OR LOWER(c.roleApplied.jobRoleName) = LOWER(:roleApplied))" +
                "ORDER BY c.candidateId ASC")
        List<Candidate> searchCandidates(String keyword,
                                         String gender,
                                         String visaStatus,
                                         String profile,
                                         String rejectionStage,
                                         String education,
                                         String degree,
                                         String roleApplied);
    }





