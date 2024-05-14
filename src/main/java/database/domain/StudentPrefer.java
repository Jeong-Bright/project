package database.domain;

import jakarta.persistence.*;

@Entity
public class StudentPrefer {


    @Id
    @GeneratedValue
    @Column(name = "PREFER_ID")
    private Long id;
    @Column(name = "PREFER_FIRST")
    private String first;
    @Column(name = "PREFER_SECOND")
    private String second;
    @Column(name = "PREFER_THIRD")
    private String third;
    @Column(name = "NONPREFER")
    private String nonePrefer;
    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    public StudentPrefer() {

    }
}
