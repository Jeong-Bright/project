package database.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Lecture {

    public Lecture() {
    }

    @Id
    @Column(name = "LECTURE_ID")
    private Long id;
    @Column(name = "LECTURE_NAME")
    private String name;
    @Column(name = "PROFESSOR_NAME")
    private String professor;
    @Column(name = "DEPARTMENT")
    private String department;
    @Lob
    @Column(name = "LECTURE_INFO")
    private String information;
    @Column(name = "LECTURE_DIVIDE")
    private int devide;
}
