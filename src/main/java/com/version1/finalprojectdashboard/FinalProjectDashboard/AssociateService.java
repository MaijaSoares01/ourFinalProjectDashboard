package com.version1.finalprojectdashboard.FinalProjectDashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssociateService {

    @Autowired
    private AssociateRepository associateRepository;

//    private final AssociateRepository associateRepository;
//
//    @Autowired
//    public AssociateService(AssociateRepository associateRepository) {
//        this.associateRepository = associateRepository;
//    }

    public List<Associate> getAllAssociates() {
        return associateRepository.findAll();
    }

    public Optional<Associate> getAssociateById(int id) {
        return associateRepository.findById(id);
    }
}
