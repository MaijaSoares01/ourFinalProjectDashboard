package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TIAService {
    @Autowired
    private TIARepository tiaRepository;

    public List<TIA> getallTIAs() {
        return tiaRepository.findAll();
    }

    public Optional<TIA> getTIAById(int id) {
        return tiaRepository.findById(id);
    }

}
