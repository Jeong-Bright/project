package database.repository;

import database.domain.StudentGrades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentGradesRepository extends JpaRepository<StudentGrades, Long> {

}
