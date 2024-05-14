package database.Controller;

import database.domain.Student;
import org.springframework.ui.Model;
import database.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/")
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "basic/login";
    }

    @PostMapping("/")
    public String login(@Valid LoginForm loginForm , BindingResult result) {
        log.info("id : {}, pwd : {}", loginForm.getId(), loginForm.getPassword());

        if (result.hasErrors()) {
            return "/";
        }
        Optional<Student> student = loginService.loginCheck(loginForm);

        if (student.isPresent()) {
            System.out.println("성공");
            return "basic/intro";
        }
        else {
            System.out.println("오류 발생");
            return "redirect:/";

        }
    }

}
