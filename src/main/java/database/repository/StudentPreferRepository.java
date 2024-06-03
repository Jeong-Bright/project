package database.repository;

import database.domain.DepartmentString;
import database.domain.Departments;
import database.domain.StudentPrefer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentPreferRepository extends JpaRepository<StudentPrefer, Long> {
    @Query(value = "SELECT sp.first from StudentPrefer sp " +
        "LEFT JOIN Student st ON sp.student.id = st.id " +
        "WHERE sp.id = :id")
    public String findByFirst(Long id);
    @Query(value = "SELECT sp.second from StudentPrefer sp " +
            "LEFT JOIN Student st ON sp.student.id = st.id " +
            "WHERE sp.id = :id")
    public String findBySecond(Long id);

    @Query(value = "SELECT sp.third from StudentPrefer sp " +
            "LEFT JOIN Student st ON sp.student.id = st.id " +
            "WHERE sp.id = :id")
    public String findByThird(Long id);

    public Optional<StudentPrefer> findByStudentId(Long id);

    public int countByFirst(String dep);
    public int countBySecond(String dep);
    public int countByThird(String dep);

}
