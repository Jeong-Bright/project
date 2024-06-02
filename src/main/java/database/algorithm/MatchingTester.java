package database.algorithm;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

    /*
     * ---------------------------------------------------
     * 
     *  <학생 - 학과 매칭 알고리즘>
     * 
     *  Stable Matching Problem : Gale-Shapley Algorithm
     * 
     * ---------------------------------------------------
     * 
     *  고민해야 할 것...
     * 
     *   1. 비 선호 학과도 매칭 시에 고려.
     * 
     *   2. 학과 정원이 고정이 아닌, 변동인 경우?
     *      -> 최소 70%, 최대 130%
     */

public class MatchingTester {

    public static final int STUDENT = 1000; // 학생의 수

    public static final int DEPARTMENT = 25; // 학과의 수
    
    public static final int DEPARTMENT_CAPACITY = 40;

    public static void main(String[] args) {
        matching();
    }

    public static void addRandomStudents(List<StudentAlgorithm> studentAlgorithms, List<Department> departments, int studentCount) {
        Random random = new Random();
        for(int i = 1; i <= studentCount; i++) {
            StudentAlgorithm studentAlgorithm = new StudentAlgorithm(Integer.toString(i)); // student.getId();
//            double grade = random.nextInt(46) / 10.0; // 성적 : 0.0 ~ 4.5 // student.getGrade();
            
            // 랜덤 성적 설정
//            student.setGrade(Math.round(grade * 100) / 100.0);

            // 랜덤 학과, 랜덤 횟수 지원 (최대 Student.MAX_APPLY)
            int applyCnt = random.nextInt(StudentAlgorithm.MAX_APPLY) + 1;
            for(int j = 0; j < applyCnt; j++) {
                int randomIndex = random.nextInt(departments.size());
                String preferDepartment = departments.get(randomIndex).getId();
                studentAlgorithm.addPreferred(preferDepartment);
            } // studentprefer.getfirst , second, third();
            
            studentAlgorithms.add(studentAlgorithm);

            // 이 쪽이 service가 될 부분
        }
    }

    public static void addDepartments(List<Department> departments, int departmentCount) {
        for(int i = 1; i <= departmentCount; i++) {
            Department department = new Department(Integer.toString(i), DEPARTMENT_CAPACITY);
            departments.add(department);
        }
    }

    public static void printOrderByGrade(List<StudentAlgorithm> matchedStudentAlgorithm) {
        Collections.sort(matchedStudentAlgorithm);
        for(StudentAlgorithm studentAlgorithm : matchedStudentAlgorithm) {
            System.out.println("학생" + studentAlgorithm.getStudentID() +
                                " (성적 : " + studentAlgorithm.getGrade() +
                                " / 학과 : " + studentAlgorithm.getMatchedDepartment() + ")");
        }
    }

    public static void matching() {
        List<Department> departments = new LinkedList<>();
        addDepartments(departments, DEPARTMENT);

        List<StudentAlgorithm> studentAlgorithms = new LinkedList<>();
        addRandomStudents(studentAlgorithms, departments, STUDENT);

        System.out.print("\n\n-------------------  Matching Result  -------------------\n");

        MatchingManager matcher = new MatchingManager(studentAlgorithms, departments);
        List<StudentAlgorithm> matchedStudentAlgorithm = matcher.matching(0.7, 1.3);
        print(departments);
        
        System.out.print("\n\n            매칭된 총 인원");
        System.out.printf("%16s", " : " + matchedStudentAlgorithm.size() + " / " + STUDENT);
        System.out.print("\n            선호도 점수 총합" );
        System.out.printf("%13s", " : " + matcher.getTotalPreference() + " / " + StudentAlgorithm.MAX_APPLY * STUDENT);
        System.out.println("\n\n---------------------------------------------------------\n\n");

        // 이 쪽이 controller가 될 부분
    
    }

    public static void print(List<Department> departments) {
        int i = 0;
        System.out.println();
        for(Department department : departments) {
            System.out.printf("%10s", "학과");
            System.out.printf("%2s", department.getId());
            System.out.printf("%10s", "(" + department.getApplicants() + " / " + department.getCapacity() + ")");
            i++;
            if(i % 2 == 0) {
                System.out.println();
            }
        }
    }
}
