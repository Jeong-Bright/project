package database.controller;

import database.domain.Student;
import database.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class LectureController {

    private final StudentRepository studentRepository;

    public LectureController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @GetMapping("myLecture")
    public String lecturePage( @SessionAttribute(name = "studentLogin", required = false) Student student,
                              Model model) {


        String[] credits = studentRepository.findByLecture(student.getId());
        String[] title = studentRepository.findByDevide(student.getId());
        String[] info = studentRepository.findByInformation(student.getId());

        model.addAttribute("credits", credits);
        model.addAttribute("title", title);
        model.addAttribute("info", info);

        return "basic/lecture";
    }
}
