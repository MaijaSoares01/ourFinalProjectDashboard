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
            // Check if the admin user exists, if not create one
            User user = new User();
            Optional<User> existingAdmin = userRepo.findByUsername("admin");
            if (!existingAdmin.isPresent()) {
                user = new User();
                user.setUsername("admin");
                user.setPassword(passwordEnc.encode("password"));
                user.setActive(true);
                user.setRoles("ADMIN");
                userRepo.save(user);
            }
//            user = new User();
//            user.setUsername("user");
//            user.setPassword(passwordEnc.encode("password"));
//            user.setActive(true);
//            user.setRoles("USER");
//            userRepo.save(user);
//
//            user = new User();
//            user.setUsername("user2");
//            user.setPassword(passwordEnc.encode("password"));
//            user.setActive(true);
//            user.setRoles("USER");
//            userRepo.save(user);
//
//            user = new User();
//            user.setUsername("admin2");
//            user.setPassword(passwordEnc.encode("password"));
//            user.setActive(true);
//            user.setRoles("ADMIN");
//            userRepo.save(user);
        };
    }
}
