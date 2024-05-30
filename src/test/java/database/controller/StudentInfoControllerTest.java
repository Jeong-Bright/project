package database.controller;

import database.domain.DepartmentDTO;
import database.domain.Departments;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class StudentInfoControllerTest {

    @Test
    @GetMapping
    String studentInfo(Model model) {
        model.addAttribute("dep", Departments.values());
        return "test";
    }

    @Test
    @PostMapping
    public String testPost(@ModelAttribute("testDTO") DepartmentDTO testDTO) {
        System.out.println("testDTO.getFirstPrefer() = " + testDTO.getDepartmentString());
        return "/";
    }
}