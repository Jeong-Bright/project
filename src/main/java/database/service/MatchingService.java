package database.service;

import database.algorithm.Department;
import database.algorithm.MatchingManager;
import database.algorithm.StudentAlgorithm;
import database.domain.Departments;
import database.domain.Student;
import database.repository.StudentPreferRepository;
import database.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class MatchingService {

    private final StudentRepository studentRepository;
    private final StudentPreferRepository studentPreferRepository;

    public MatchingService(StudentRepository studentRepository, StudentPreferRepository studentPreferRepository) {
        this.studentRepository = studentRepository;
        this.studentPreferRepository = studentPreferRepository;
    }

    public List<Department> insertDepartments() {
        List<Department> departments = new LinkedList<>();

        for(int i = 0; i < 25; i++) {
            Departments value = Departments.values()[i];
            String department1 = value.getDepartment();
            Department department = new Department(department1, 40);
            departments.add(department);
        }

        return departments;
    }

    public List<StudentAlgorithm> insertStudents() {
        List<StudentAlgorithm> students = new LinkedList<>();
        for(int i = 0; i < 1000; i++) {

            List<Student> studentList = studentRepository.findAll();
            Student studentGrades = studentList.get(i);

            StudentAlgorithm studentAlgorithm = new StudentAlgorithm(studentGrades);
            String byFirst = studentPreferRepository.findByFirst(studentGrades.getId());
            studentAlgorithm.addPreferred(byFirst);
            String bySecond = studentPreferRepository.findBySecond(studentGrades.getId());
            studentAlgorithm.addPreferred(bySecond);
            String byThird = studentPreferRepository.findByThird(studentGrades.getId());
            studentAlgorithm.addPreferred(byThird);

            students.add(studentAlgorithm);
        }

        return students;
    }

    public int[] matching(List<StudentAlgorithm> studentAlgorithmList,
                          List<Department> departmentList) {

        MatchingManager matcher = new MatchingManager(studentAlgorithmList, departmentList);
        List<StudentAlgorithm> matchedStudentAlgorithm = matcher.matching(0.7, 1.3);

        int totalPreference = matcher.getTotalPreference();
        int size = matchedStudentAlgorithm.size();

        return new int[]{totalPreference, size};
    }

}
