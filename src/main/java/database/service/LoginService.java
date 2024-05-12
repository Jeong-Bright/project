package database.service;


import database.Controller.LoginForm;
import database.domain.Student;
import database.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
//@Transactional(readOnly = true)
public class LoginService {

    @Autowired
    private final StudentRepository studentRepository;

    public boolean loginCheck(LoginForm loginForm) {
        System.out.println("LoginService.loginCheck");
        boolean studentId = studentRepository.existsStudentByStudentId(loginForm.getId());
        boolean studentPwd = studentRepository.existsStudentByPassword(loginForm.getPassword());

        if(!studentId) return false;
        if(!studentPwd) return false;
        return true;
    }

    public List<Student> user() {
        return studentRepository.findAll();
    }

}
