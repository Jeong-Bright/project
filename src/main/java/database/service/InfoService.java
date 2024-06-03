package database.service;

import database.domain.Student;
import database.domain.StudentPrefer;
import database.repository.StudentPreferRepository;
import database.repository.StudentRepository;
import jakarta.persistence.EntityManager;
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


    @Transactional
    public void updatePrefer(Student student, String first, String second, String third, Long id) {

        StudentPrefer studentPrefer = studentPreferRepository.findById(id).get();
        Long id1 = studentPrefer.getId();
        if (id1 != null) {
            studentPrefer.setFirst(first);
            studentPrefer.setSecond(second);
            studentPrefer.setThird(third);
        }

    }

    public StudentPrefer savePrefer(String first, String second, String third, Long id) {
        Optional<StudentPrefer> studentPrefer = studentPreferRepository.findByStudentId(id);

        if(studentPrefer.isEmpty()) {
            return studentPreferRepository.save(
                    StudentPrefer.builder()
                            .first(first)
                            .second(second)
                            .third(third)
                            .build()
            );
        }
        else return null;
    }

    public Map<String , String> departmentPrefer(Long id) {
        Map<String , String> preferMap = new ConcurrentHashMap<>();

        String byFirst = studentPreferRepository.findByFirst(id);
        String bySecond = studentPreferRepository.findBySecond(id);
        String byThird = studentPreferRepository.findByThird(id);

        preferMap.put("first", byFirst);
        preferMap.put("second", bySecond);
        preferMap.put("third", byThird);

        return preferMap;
    }



}

