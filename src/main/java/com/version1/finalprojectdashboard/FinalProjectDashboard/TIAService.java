package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
