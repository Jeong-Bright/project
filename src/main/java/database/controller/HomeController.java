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

    @GetMapping("intro")
    public String home(Model model, @SessionAttribute(name = "studentLogin", required = false) Student student) {

        if (student != null) {
            model.addAttribute("name", student.getName());
            return "basic/intro";
        }

        return "basic/login";
    }

    @GetMapping("introduce")
    public String departmentIntroduce() {
        return "basic/departmentintro";
    }


}

