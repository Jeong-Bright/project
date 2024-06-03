package database.repository;

import database.domain.DepartmentString;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentStringRepository extends JpaRepository<DepartmentString, Long> {
}
