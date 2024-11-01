package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
public class DBInitializerConfig {
//    @Autowired
//    UserRepository userRepo;

    @Autowired
    PasswordEncoder passwordEnc;

//    @Autowired
//    AssociateRepository associateRepository;

    @Autowired
    CandidateRepository candidateRepository;

//    @Autowired
//    TIARepository tiaRepository;
//
//    @Autowired
//    JobRoleRepository jobRoleRepository;
//
//    @Autowired
//    TimesheetRepository timesheetRepository;


    @Bean
    public CommandLineRunner initializeJpaData() {
        return (args) ->{
//            Optional<User> o = userRepo.findByUsername("Chester");
//            if (!o.isPresent()) {
//                User u = new User();
//                u.setUsername("Chester");
//                u.setPassword(passwordEnc.encode("password"));
//                u.setActive(true);
//                u.setRoles("ADMIN");
//                userRepo.save(u);
//            }
        };
    }
}
