package database.service;

import database.domain.Student;
import database.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PasswordEditService {

    private final StudentRepository studentRepository;

    public boolean checkPassword(String before) {
        boolean check = studentRepository.existsStudentByPassword(before);

        return check;
    }

    @Transactional
    public void editPassword(String editPwd, Long id) {
        Optional<Student> st = studentRepository.findById(id);

        st.ifPresent(student -> student.setPassword(editPwd));
    }
}