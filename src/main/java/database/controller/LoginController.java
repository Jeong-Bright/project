package database.controller;

import database.domain.Student;
import database.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final UserService userService;

    @GetMapping("/")
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "basic/login";
    }

    @PostMapping("/")
    public String login(@Valid LoginForm loginForm , BindingResult result,
                        HttpServletRequest request) {
        log.info("id : {}, pwd : {}", loginForm.getId(), loginForm.getPassword());
        if (result.hasErrors()) {
            return "/";
        }
        Optional<Student> loginCheck = userService.loginCheck(loginForm);
        Student student = loginCheck.get();
        if (student != null) {
            System.out.println("성공");
            HttpSession httpSession = request.getSession(true);
            httpSession.setAttribute("student", student);
            return "basic/intro";
        }

        else {
            System.out.println("오류 발생");
            return "redirect:/";

        }
    }

}
