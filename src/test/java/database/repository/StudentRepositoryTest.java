package database.repository;

import database.controller.LoginForm;
import database.domain.DepartmentString;
import database.domain.Departments;
import database.domain.Student;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EntityManager entityManager;

    @Test
    void tet() {/*
        List<Student> byStudentId = studentRepository.findByStudentId("202117072");
        String studentId = byStudentId.stream().iterator().getStudentId();
        System.out.println("studentId = " + studentId);*/

        DepartmentString departmentString = new DepartmentString();
        Departments departments = Departments.values()[0];
        System.out.println("departments = " + departments);

    }

}