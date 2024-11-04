package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/timesheet")
public class TimesheetController {
    @Autowired
    TimesheetService timesheetService;

    @GetMapping
    public List<Timesheet> getAllTimesheets() {
        return timesheetService.getAllTimesheets();
    }

    @GetMapping("/{id}")
    public Optional<Timesheet> getTimesheetById(@PathVariable int id) {
        return timesheetService.getTimesheetById(id);
    }

}
