package database.service;


import database.controller.LoginForm;
import database.domain.Student;
import database.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
//@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private final StudentRepository studentRepository;

    public Student loginCheck(LoginForm loginForm) {
        System.out.println("LoginService.loginCheck");
        Optional<Student> login = studentRepository.findStudentByStudentId(loginForm.getId());
        if (login.isEmpty()) {
            return null;
        }
        Student student = login.get();
        if(!student.getPassword().equals(loginForm.getPassword())) {
            return null;
        }

        return student;
    }

    public List<Student> user() {
        return studentRepository.findAll();
    }

    public Student getStudent(Long studentId) {

        Optional<Student> student = studentRepository.findStudentByStudentId(String.valueOf(studentId));
        return student.orElse(null);

    }

}
