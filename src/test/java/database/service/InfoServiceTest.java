package database.service;

import database.domain.Student;
import database.domain.StudentPrefer;
import database.repository.StudentPreferRepository;
import database.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class InfoServiceTest {

    @Autowired
    private InfoService infoService;
    @Autowired
    private StudentPreferRepository studentPreferRepository;
    @Autowired
    private StudentRepository studentRepository;


    @Test
    void test() {
//        Map<String, Optional<StudentPrefer>> studentPreferMap = infoService.departmentPrefer(1L);
//        Assertions.assertThat(studentPreferMap.size()).isEqualTo(0);

        StudentPrefer studentPrefer = new StudentPrefer();
        String byId = (studentPreferRepository.findByFirst(1L));
//

//        System.out.println("byId = " + byId);
        Student student = new Student();
        Optional<Student> byId1 = studentRepository.findById(1L);
        System.out.println("byId1 = " + byId);

        infoService.updatePrefer(byId1.get(), "화학공학과", "건축공학과", "도시공학과", 1L);
        String byId2 = (studentPreferRepository.findByFirst(1L));
        System.out.println("byId2 = " + byId2);



//        infoService.updatePrefer();

    }

}