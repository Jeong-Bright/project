package database.controller;

import database.algorithm.Department;
import database.algorithm.StudentAlgorithm;
import database.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MatchingController {

    private final MatchingService matchingService;
    @Autowired
    public MatchingController(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    @GetMapping("matching")
    public String matchingPage(Model model) {

        List<Department> departmentsList = matchingService.insertDepartments();
        List<StudentAlgorithm> studentAlgorithms = matchingService.insertStudents();
        model.addAttribute("departmentsList", departmentsList);

        int[] matching = matchingService.matching(studentAlgorithms, departmentsList);
        model.addAttribute("matchingResult", matching);

        return "basic/matching";
    }
}
