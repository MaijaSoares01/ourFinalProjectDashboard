package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TIAController {

    @Autowired
    TIAService tiaService;

    @GetMapping
    public List<TIA> getAllTIAs() {
        return tiaService.getallTIAs();
    }

    @GetMapping("/{id}")
    public Optional<TIA> getTIAById(@PathVariable int id) {
        return tiaService.getTIAById(id);
    }

}
