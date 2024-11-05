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

//    @Autowired
//    private UserRoleRepository userRoleRepository;

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


//            UserRole adminRole = userRoleRepository.findByName("ROLE_ADMIN")
//                    .orElseGet(() -> {
//                        UserRole newRole = new UserRole("ROLE_ADMIN");
//                        userRoleRepository.save(newRole);
//                        System.out.println("Created role: " + newRole.getName());
//                        return newRole;
//                    });
//
//            UserRole userRole = userRoleRepository.findByName("ROLE_USER")
//                    .orElseGet(() -> {
//                        UserRole newRole = new UserRole("ROLE_USER");
//                        userRoleRepository.save(newRole);
//                        System.out.println("Created role: " + newRole.getName());
//                        return newRole;
//                    });

            Optional<User> existingAdmin = userRepo.findByUsername("admin");
            if (!existingAdmin.isPresent()) {
                User user = new User();
                user.setUsername("admin");
                user.setPassword(passwordEnc.encode("password"));
                user.setActive(true);
                user.setRoles("ADMIN");
                userRepo.save(user);
            }

//            Optional<User> existingAdmin = userRepo.findByUsername("admin");
//            if (!existingAdmin.isPresent()) {
//                User adminUser = new User();
//                adminUser.setUsername("admin");
//                adminUser.setPassword(passwordEnc.encode("password"));
//                adminUser.setActive(true);
//                adminUser.setRoles(List.of(adminRole, userRole));
//                userRepo.save(adminUser);
//                System.out.println("Created admin user: " + adminUser.getUsername());
//            }
        };
    }
}
