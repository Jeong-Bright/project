package database.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @Column(name = "STUDENT_ID")
    private String studentId;
    @Column(name = "STUDENT_PWD")
    private String password;
    @Column(name = "STUDENT_NAME")
    private String name;
    @Column(name = "STUDENT_PHONE")
    private String phone;
    @Column(name = "STUDENT_CREDIT")
    private double credit;

}
