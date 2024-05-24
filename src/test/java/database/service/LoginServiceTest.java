package database.service;

import database.controller.LoginForm;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import database.domain.Student;
import database.repository.StudentRepository;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class LoginServiceTest {

    @Autowired
//    private LoginController loginController;
//    private UserService userService;
    private StudentRepository studentRepository;
    @Test
    void all() {
//        List<Student> all = studentRepository.findAll();
        Student student = Student.builder()
                .credit(0)
                .email("wjswjdgus333@gmail.com")
                .name("김성강")
                .password("power123")
                .phone("01012345678")
                .studentId("202114325")
                .build();
        studentRepository.save(student);
/*        boolean studentId = studentRepository.existsStudentByStudentId("202117072");
        assertThat(studentId).isEqualTo(true);
        boolean byPassword = studentRepository.existsStudentByPassword("cider123");
        assertThat(byPassword).isEqualTo(true);*/


//        assertThat(password).isEqualTo("cider123");
    }

/*
    @Test
    void tst() {
        LoginForm loginForm = new LoginForm();
        loginForm.setId("202117072");
        loginForm.setPassword("cider123");
        Student student = new Student();

        Optional<Student> student1 = userService.loginCheck(loginForm);

//        System.out.println(login);
    }
*/

}