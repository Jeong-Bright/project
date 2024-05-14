package database.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Lecture {

    public Lecture() {
    }

    @Id
    @GeneratedValue
    @Column(name = "LECTURE_ID")
    private Long id;
    @Column(name = "LECTURE_NAME")
    private String name;
    @Column(name = "PROFESSOR_NAME")
    private String professor;
    @Column(name = "DEPARTMENT")
    private String department;
    @Column(name = "LECTURE_INFO", length = 65535)
    private String information;
    @Column(name = "LECTURE_DIVIDE")
    private int devide;
}
