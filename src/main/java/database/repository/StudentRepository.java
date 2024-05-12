package database.repository;

import database.domain.Student;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
//    @Query(value = "SELECT s from Student s where s.studentId = :student_id")
    public List<Student> findByStudentId(String studentId);

    public boolean existsStudentByStudentId(String studentId);

    public boolean existsStudentByPassword(String password);


}
