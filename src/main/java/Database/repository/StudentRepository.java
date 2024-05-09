package Database.repository;

import Database.domain.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    private static final Map<Long, Student> studentList = new HashMap();

    public Optional<Student> findByLoginId(Long loginId) {
        return null;
    }



}
