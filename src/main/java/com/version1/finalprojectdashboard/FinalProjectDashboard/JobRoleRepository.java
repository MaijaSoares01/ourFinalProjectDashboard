package com.version1.finalprojectdashboard.FinalProjectDashboard;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRoleRepository extends JpaRepository<JobRole, Integer> {

	//Finding by role name
	List<JobRole> findByJobRoleName(String jobRoleName);
}
