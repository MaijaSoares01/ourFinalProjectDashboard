package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Configuration
public class DBInitializerConfig {
    @Autowired
    UserRepository userRepo;

    @Autowired
    PasswordEncoder passwordEnc;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    AssociateRepository associateRepository;

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    TIARepository tiaRepository;

    @Autowired
    JobRoleRepository jobRoleRepository;

    @Autowired
    TimesheetRepository timesheetRepository;

    @Bean
    public CommandLineRunner initializeJpaData() {
        return (args) -> {
            // Ensure roles exist in the database
            UserRole adminRole = userRoleRepository.findByName("ROLE_ADMIN")
                    .orElseGet(() -> userRoleRepository.save(new UserRole("ROLE_ADMIN")));
            UserRole userRole = userRoleRepository.findByName("ROLE_USER")
                    .orElseGet(() -> userRoleRepository.save(new UserRole("ROLE_USER")));

            // Check if the admin user exists, if not create one
            Optional<User> existingAdmin = userRepo.findByUsername("admin");
            if (!existingAdmin.isPresent()) {
                User adminUser = new User();
                adminUser.setUsername("admin");
                adminUser.setPassword(passwordEnc.encode("password"));
                adminUser.setActive(true);
                adminUser.setRoles(List.of(adminRole, userRole)); // Assuming roles is a List<Role>
                userRepo.save(adminUser);
            }

            // Optionally, initialize other repositories if needed
            // For example:
            // if (associateRepository.count() == 0) {
            //     Associate associate = new Associate(/* initialize fields */);
            //     associateRepository.save(associate);
            // }

            // Similar initialization can be done for candidateRepository, tiaRepository, etc.
        };
    }
}
