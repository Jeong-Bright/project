package database.service;

import database.Controller.LoginController;
import database.Controller.LoginForm;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import database.domain.Student;
import database.repository.StudentRepository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class LoginServiceTest {

    @Autowired
//    private LoginController loginController;
//    private LoginService loginService;
    private StudentRepository studentRepository;
    @Test
    void all() {
//        List<Student> all = studentRepository.findAll();
        Student student = Student.builder()
                .studentId("202117072")
                .password("cider123")
                .name("전정현")
                .phone("01077238081")
                .email("wjswjdgus333@gmail.com")
                .credit(0)
                .build();
        studentRepository.save(student);
/*        boolean studentId = studentRepository.existsStudentByStudentId("202117072");
        assertThat(studentId).isEqualTo(true);
        boolean byPassword = studentRepository.existsStudentByPassword("cider123");
        assertThat(byPassword).isEqualTo(true);*/


//        assertThat(password).isEqualTo("cider123");
    }

    @Test
    void tst() {
        LoginForm loginForm = new LoginForm();
        loginForm.setId("202117072");
        loginForm.setPassword("cider123");
//        Optional<Student> student = loginService.loginCheck(loginForm);
//        assertThat(student).isNotNull();


//        String login = loginController.login(loginForm);
//        System.out.println(login);
    }

}