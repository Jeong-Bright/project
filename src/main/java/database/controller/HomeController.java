package database.controller;

import database.domain.Student;
import database.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping("/intro")
    public String home(Model model, @SessionAttribute(name = "student", required = false) Student student) {

        Student checkStudent = userService.getStudent(student.getId());
        if (checkStudent != null) {
            System.out.println("checkStudent = " + checkStudent);
            model.addAttribute("name", student.getName());
        }
        else {
            System.out.println("HomeController.home");
        }

        return "basic/intro";
    }

    @GetMapping("/basic/introduce")
    public String departmentIntroduce() {
        return "basic/departmentintro";
    }

    @GetMapping("/basic/info")
    public String studentInfo() {
        return "basic/departmentintro";
    }

}

