package database.service;

import database.domain.Student;
import database.domain.StudentPrefer;
import database.repository.StudentPreferRepository;
import database.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class InfoService {
    private final StudentPreferRepository studentPreferRepository;
    private final StudentRepository studentRepository;



    @Transactional
    public void updatePrefer(Student student, String first, String second, String third, String none, Long id) {

        Optional<StudentPrefer> studentPrefer = studentPreferRepository.findByStudentId(id);

        studentPrefer.ifPresent(student_Prefer -> student_Prefer.editPrefer(first, second, third, none, student));
    }

    public StudentPrefer savePrefer(Student student, String first, String second, String third, String none, Long id) {
        Optional<StudentPrefer> studentPrefer = studentPreferRepository.findByStudentId(id);

        if(studentPrefer.isEmpty()) {
            return studentPreferRepository.save(
                    StudentPrefer.builder()
                            .student(student)
                            .first(first)
                            .second(second)
                            .third(third)
                            .nonePrefer(none)
                            .build()
            );
        }
        else return null;
    }

    public Map<String , Optional<StudentPrefer>> departmentPrefer(Long id) {
        Map<String , Optional<StudentPrefer>> preferMap = new ConcurrentHashMap<>();

        Optional<StudentPrefer> byFirst = studentPreferRepository.findByFirst(id);
        Optional<StudentPrefer> bySecond = studentPreferRepository.findBySecond(id);
        Optional<StudentPrefer> byThird = studentPreferRepository.findByThird(id);
        Optional<StudentPrefer> byNonePrefer = studentPreferRepository.findByNonePrefer(id);

        preferMap.put("first", byFirst);
        preferMap.put("second", bySecond);
        preferMap.put("third", byThird);
        preferMap.put("nonValue", byNonePrefer);

        return preferMap;
    }



}

