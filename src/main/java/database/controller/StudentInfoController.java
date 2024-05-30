package database.controller;

import database.domain.*;
import database.service.InfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
@AllArgsConstructor
@Slf4j
public class StudentInfoController {

    private InfoService infoService;

    @GetMapping("info")
    public String studentInfo(Model model, @SessionAttribute(name = "studentLogin", required = false) Student student
    ) {

        if (student != null) {
            model.addAttribute("name", student.getName());
            model.addAttribute("num", student.getStudentId());
            model.addAttribute("call", student.getPhone());
        }
        return "basic/info";
    }

    @PostMapping("info")
    public String DepartmentChoice(
            @RequestParam("firstValue") String firstValue,
            @RequestParam("secondValue") String secondValue,
            @RequestParam("thirdValue") String thirdValue,
            @RequestParam("noneValue") String noneValue,
            // 중복체크 -> Set으로
            @SessionAttribute(name = "studentLogin", required = false) Student student
            // Map 형태로 받는거 고려
    ) {

        StudentPrefer studentPrefer = infoService
                .savePrefer(student, firstValue, secondValue, thirdValue, noneValue, student.getId());

        if (studentPrefer == null) {
            infoService.updatePrefer(student, firstValue, secondValue, thirdValue, noneValue, student.getId());
        }

        return "redirect:/info";

    }

    @ModelAttribute("departmentList")
    public Departments[] departmentList() {
        return Departments.values();
    }

    @GetMapping("info/prefer") // DTO로 받는거 고려
    public String myPrefer(@SessionAttribute(name = "studentLogin", required = false) Student student,
                           Model model) {

        Map<String, Optional<StudentPrefer>> studentPreferMap = infoService.departmentPrefer(student.getId());
        model.addAttribute("map", studentPreferMap);

        if (studentPreferMap == null) {
            return "redirect:/info";
        }

        return "basic/prefer";
    }

}
