package database.service;

import database.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordEditService {

    private final StudentRepository studentRepository;

    public boolean checkPassword(String before) {
        boolean check = studentRepository.existsStudentByPassword(before);

        return check;
    }



}
