package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/associates")
public class AssociateController {

    private final AssociateService associateService;

    @Autowired
    public AssociateController(AssociateService associateService) {
        this.associateService = associateService;
    }

    @GetMapping
    public List<Associate> getAllAssociates() {
        return associateService.getAllAssociates();
    }

    @GetMapping("/{id}")
    public Optional<Associate> getAssociateById(@PathVariable int id) {
        return associateService.getAssociateById(id);
    }
}
