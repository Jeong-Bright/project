package database.repository;

import database.domain.Student;
import database.domain.StudentPrefer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
//    @Query(value = "SELECT s from Student s where s.studentId = :student_id")
    public Optional<Student> findStudentsByStudentIdAndAndPassword(String studentId, String password);

    public Optional<Student> findStudentByStudentId(String studentId);

    public boolean existsStudentByPassword(String password);

    Optional<StudentPrefer> findStudentById(Long id);

    @Query("select lec.name from Student st " +
            "left join StudentLecture stl on st.id = stl.student.id " +
            "left join Lecture lec on lec.id = stl.lecture.id " +
            "where stl.student.id = :studentId")
    public String[] findByLecture(Long studentId);

    @Query("select lec.devide from Student st " +
            "left join StudentLecture stl on st.id = stl.student.id " +
            "left join Lecture lec on lec.id = stl.lecture.id " +
            "where stl.student.id = :studentId")
    public String[] findByDevide(Long studentId);

    @Query("select lec.information from Student st " +
            "left join StudentLecture stl on st.id = stl.student.id " +
            "left join Lecture lec on lec.id = stl.lecture.id " +
            "where stl.student.id = :studentId")
    public String[] findByInformation(Long studentId);
}
