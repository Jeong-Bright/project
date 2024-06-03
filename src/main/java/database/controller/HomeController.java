package database.controller;

import database.domain.Student;
import database.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Map;

@Controller
public class HomeController {

    private final RateService rateService;

    @Autowired
    public HomeController(RateService rateService) {
        this.rateService = rateService;
    }

    @GetMapping("intro")
    public String home(Model model, @SessionAttribute(name = "studentLogin", required = false) Student student) {

        if (student != null) {
            model.addAttribute("name", student.getName());
            return "basic/intro";
        }

        return "basic/login";
    }

    @GetMapping("rate")
    public String ratePage(Model model) {

        Map<String, Double> rateMap = rateService.rateCount();
        model.addAttribute("rate", rateMap);

        return "basic/rate";
    }

    @GetMapping("introduce")
    public String departmentIntroduce() {
        return "basic/departmentintro";
    }


}

