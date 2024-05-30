package database.repository;

import database.domain.StudentPrefer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentPreferRepositoryTest {

    @Autowired
    private StudentPreferRepository studentPreferRepository;

    @Test
    void test() {
        Optional<StudentPrefer> byFirst = studentPreferRepository.findByFirst(1L);
        Optional<StudentPrefer> asdf = studentPreferRepository.findBySecond(1L);
        Optional<StudentPrefer> g = studentPreferRepository.findByThird(1L);
        Optional<StudentPrefer> h = studentPreferRepository.findByNonePrefer(1L);
        System.out.println("byFirst.get() = " + byFirst.get());
        System.out.println("h = " + h);
        System.out.println("g = " + g);
        System.out.println("asdf = " + asdf);
    }

}