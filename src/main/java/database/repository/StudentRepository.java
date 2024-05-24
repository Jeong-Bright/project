package database.repository;

import database.domain.Student;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
//    @Query(value = "SELECT s from Student s where s.studentId = :student_id")
    public Optional<Student> findStudentsByStudentIdAndAndPassword(String studentId, String password);

    public Optional<Student> findStudentByStudentId(String studentId);

    public boolean existsStudentByStudentId(String studentId);

    public boolean existsStudentByPassword(String password);


}
