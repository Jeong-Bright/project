/*
package database;

import java.util.List;
import java.util.Random;

import database.domain.Departments;
import database.domain.Student;
import database.domain.StudentPrefer;
import database.repository.StudentPreferRepository;
import database.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentDataInitializer implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final StudentPreferRepository studentPreferRepository;


    @Override
    public void run(String... args) throws Exception {
        Random random2 = new Random();

        for (int i = 1; i <= 1000; i++) {
            Student student = Student.builder()
                    .credit(generateCredit(random2))
                    .email("hello@spring.com")
                    .name(generateRandomKoreanName(random2))
                    .password("1234")
                    .phone("01000000000")
                    .studentId("2024" + generateRandomStudentId(random2))
                    .build();
            studentRepository.save(student);
        }

        List<Student> students = studentRepository.findAll();
        Random random = new Random(24);
        int cnt = 0;
        for (int i = 0; i < 22; i++) {
            int ran = random.nextInt(5);
            int chk = (ran % 2 == 0) ? ran : ran - 4;
            int p = 0;
            for (int j = 1; j <= 45 + chk; j++) {
                cnt++;
                p++;
                if(p >= 23) p = 0;
                Student student = students.get(cnt);
                Departments departmentEnum = Departments.values()[p];
                Departments departmentEnum2 = Departments.values()[p+1];
                Departments departmentEnum3 = Departments.values()[p+2];

                studentPreferRepository.save(StudentPrefer.builder()
                        .student(student)
                        .first(departmentEnum.getDepartment())
                        .second(departmentEnum2.getDepartment())
                        .third(departmentEnum3.getDepartment())
                        .build());

            }
                if(cnt >= 1000) break;
            }
        }
    private double generateCredit(Random random) {
        double credit = 1.0 + (4.5 - 1.0) * random.nextDouble();
        return Math.round(credit * 10) / 10.0;
    }

    private String generateRandomKoreanName(Random random) {
        String[] consonants = {"김", "이", "박", "최", "정", "강", "조", "윤", "장", "임"};
        String[] vowels = {"아", "바", "가", "나", "다", "라", "마", "사", "자", "차"};
        return consonants[random.nextInt(consonants.length)] +
                vowels[random.nextInt(vowels.length)] +
                vowels[random.nextInt(vowels.length)];
    }

    private String generateRandomStudentId(Random random) {
        StringBuilder studentId = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            studentId.append(random.nextInt(9) + 1);
        }
        return studentId.toString();
    }
}

*/
