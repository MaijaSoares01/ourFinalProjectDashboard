package com.version1.finalprojectdashboard.FinalProjectDashboard;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobRoleService {
	
	//Injecting the JobRoleRepository so we can handle the database operations
	private JobRoleRepository jobRoleRepository;
	
	@Autowired
	public JobRoleService(JobRoleRepository jobRoleRepository) {
		this.jobRoleRepository = jobRoleRepository;
	}
	
	//Method to get a list of all job roles from the database
	public List<JobRole> getAllJobRoles(){
		return jobRoleRepository.findAll();//findAll() gets everything in the JobRole table
	}
	
	//Method to get a specific job role by id
	public Optional<JobRole> getJobRoleById(int id){
		return jobRoleRepository.findById(id); //findById() returns Optional in the case id does not exist
	}
	
	// Adds a new job role to the database
	public JobRole addJobRole(JobRole jobRole) {
		return jobRoleRepository.save(jobRole);
	}
	
	// Updates an existing job role
	public JobRole updateJobRole(JobRole jobRole) {
		return jobRoleRepository.save(jobRole);
	}
	
	// Deletes a JobRole by i
	public void deleteJobRole(int id) {
		jobRoleRepository.deleteById(id);
	}

}
