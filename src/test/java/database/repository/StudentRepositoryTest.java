package database.repository;

import database.Controller.LoginForm;
import database.domain.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    @Test
    void tet() {/*
        List<Student> byStudentId = studentRepository.findByStudentId("202117072");
        String studentId = byStudentId.stream().iterator().getStudentId();
        System.out.println("studentId = " + studentId);*/
        LoginForm loginForm = new LoginForm();
        loginForm.setId("202117072");
        loginForm.setPassword("cider123");
        Optional<Student> login = studentRepository.findStudentsByStudentIdAndAndPassword(loginForm.getId(), loginForm.getPassword());
        assertThat(login).isNotNull();
    }

}