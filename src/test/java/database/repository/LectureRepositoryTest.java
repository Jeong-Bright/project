package database.repository;

import database.domain.Departments;
import database.domain.Lecture;
import database.domain.Student;
import database.domain.StudentLecture;
import jakarta.persistence.EntityManager;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class LectureRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LectureRepository lectureRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EntityManager em;

    Student getStudent() {
        Student student = new Student();
        student.setCredit(0);
        student.setName("김성강");
        student.setPassword("power123");
        student.setStudentId("202114325");

        return studentRepository.save(student);
    }

    Lecture saveLecture(String name, String prof, String examp) {

        Lecture lecture = new Lecture();
        lecture.setName(name);
        lecture.setProfessor(prof);
        lecture.setDevide(3);
        lecture.setDepartment(Departments.SoftwareEngineering.getDepartment());
        lecture.setInformation(examp);
        return lectureRepository.save(lecture);
    }

    StudentLecture studentLecture(Student student, Lecture lecture) {
        StudentLecture studentLecture = new StudentLecture();
        studentLecture.setLecture(lecture);
        studentLecture.setStudent(student);

        return courseRepository.save(studentLecture);
    }


    @Test
//    @Transactional
    void test() {

        Student student1 = getStudent();

        Lecture lecture1 = saveLecture("웹프로그래밍기초", "류덕산", "HTML, CSS, JavaScript를 배우는 기초 강의입니다."
        );
        Lecture lecture2 = saveLecture("데이터베이스", "류덕산", "SQL 및 데이터베이스 설계를 배우는 강의입니다.");
        Lecture lecture3 = saveLecture("알고리즘", "류덕산", "효율적인 알고리즘을 설계하고 분석하는 강의입니다.");
        Lecture lecture4 = saveLecture("자료구조", "류덕산", "기본적인 자료구조를 배우고 구현하는 강의입니다.");
        Lecture lecture5 = saveLecture("운영체제", "류덕산", "운영체제의 원리를 배우는 강의입니다.");
        Lecture lecture6 = saveLecture("네트워크", "류덕산", "컴퓨터 네트워크의 기초를 배우는 강의입니다.");

        StudentLecture studentLecture = studentLecture(student1, lecture1);
        StudentLecture studentLecture1 = studentLecture(student1, lecture2);
        StudentLecture studentLecture2 = studentLecture(student1, lecture3);
        StudentLecture studentLecture3 = studentLecture(student1, lecture4);
        StudentLecture studentLecture4 = studentLecture(student1, lecture5);
        StudentLecture studentLecture5 = studentLecture(student1, lecture6);


        student1.addCourse(studentLecture);
        student1.addCourse(studentLecture1);
        student1.addCourse(studentLecture2);
        student1.addCourse(studentLecture3);
        student1.addCourse(studentLecture4);
        student1.addCourse(studentLecture5);


        lecture1.addCourse(studentLecture);
        lecture2.addCourse(studentLecture1);
        lecture3.addCourse(studentLecture2);
        lecture4.addCourse(studentLecture3);
        lecture5.addCourse(studentLecture4);
        lecture6.addCourse(studentLecture5);

        lectureRepository.saveAll(Lists.newArrayList(lecture1, lecture2, lecture3, lecture4, lecture5, lecture6));


    }
}
