package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

// Component to handle updating JobRole entities
@Component
public class JobRoleUpdate {

    // Injecting the JobRoleRepository to interact with the database
    private final JobRoleRepository jobRoleRepository;

    @Autowired
    public JobRoleUpdate(JobRoleRepository jobRoleRepository) {
        this.jobRoleRepository = jobRoleRepository;
    }

    // Method to update an existing JobRole
    public String updateJobRole(JobRole jobRole) {
        // Find the existing JobRole by ID
        Optional<JobRole> existingJobRoleOptional = jobRoleRepository.findById(jobRole.getJobRoleId());

        // Check if JobRole exists
        if (existingJobRoleOptional.isEmpty()) {
            return "Job role not found :("; // Return message if not found
        } else {
            JobRole existingJobRole = existingJobRoleOptional.get();
            existingJobRole.setJobRoleName(jobRole.getJobRoleName());
            existingJobRole.setNumApplications(jobRole.getNumApplications());
            existingJobRole.setNumSourcePaid(jobRole.getNumSourcePaid());
            existingJobRole.setNumSourceCRM(jobRole.getNumSourceCRM());
            existingJobRole.setNumSourceReferral(jobRole.getNumSourceReferral());
            existingJobRole.setNumSourceOrganic(jobRole.getNumSourceOrganic());
            existingJobRole.setNumSourceAgency(jobRole.getNumSourceAgency());
            existingJobRole.setNumSourceOther(jobRole.getNumSourceOther());
            existingJobRole.setNumInterviews(jobRole.getNumInterviews());
            existingJobRole.setNumRejected(jobRole.getNumRejected());

            // Save the updated JobRole back to the database
            jobRoleRepository.save(existingJobRole);
            return "Job role updated successfully!"; // Success message
        }
    }
}
