package Database.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class Student {

    @Id
    @Column(name = "STUDENT_ID")
    private Long studentId;
    @Column(name = "STUDENT_PWD")
    private String password;
    @Column(name = "STUDENT_NAME")
    private String name;
    @Column(name = "STUDENT_PHONE")
    private String phone;
    @Column(name = "STUDENT_CREDIT")
    private double credit;

    public Student() {

    }
}
