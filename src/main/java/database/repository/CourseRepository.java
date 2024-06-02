package database.repository;


import database.domain.StudentLecture;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<StudentLecture, Long> {

    @Query("select lec.name from StudentLecture stl " +
            "left join Lecture lec on lec.id = stl.lecture.id " +
            "where stl.student.id = :studentId")
    public Optional<StudentLecture> findByLecture(Long id, Long studentId);

    @Query("select lec.devide from StudentLecture stl " +
            "left join Lecture lec on lec.id = stl.lecture.id " +
            "where stl.student.id = :studentId")
    public Optional<StudentLecture> findByDevide(Long id, Long studentId);

    @Query("select lec.information from StudentLecture stl " +
            "left join Lecture lec on lec.id = stl.lecture.id " +
            "where stl.student.id = :studentId")
    public Optional<StudentLecture> findByInformation(Long id, Long studentId);

}
