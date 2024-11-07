package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/api/associates")
public class AssociateController {

    @Autowired
    AssociateService associateService;

//    @Autowired
//    public AssociateController(AssociateService associateService) {
//        this.associateService = associateService;
//    }

    @GetMapping("/associates")
    public String getAllAssociates(Model model) {
        List<Associate> associates = associateService.getAllAssociates();
        model.addAttribute("associates", associates);
        return "showAssociates";
    }

//    @GetMapping("/{id}")
//    public Optional<Associate> getAssociateById(@PathVariable int id) {
//        return associateService.getAssociateById(id);
//    }
}
