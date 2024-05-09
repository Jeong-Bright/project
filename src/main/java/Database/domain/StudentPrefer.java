package Database.domain;

import jakarta.persistence.*;

@Entity
public class StudentPrefer {


    @Id
    @Column(name = "STUDENT_ID")
    private Long id;

    @Id
    @Column(name = "PREFER_FIRST")
    private String first;



    public StudentPrefer() {

    }
}
