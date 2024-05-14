package database.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {


    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ID")
    private Long id;
    @Column(name = "STUDENT_NUM")
    private String studentId;
    @Column(name = "STUDENT_PWD")
    private String password;
    @Column(name = "STUDENT_NAME")
    private String name;
    @Column(name = "STUDENT_PHONE")
    private String phone;
    @Column(name = "STUDENT_MAIL")
    private String email;
    @Column(name = "STUDENT_CREDIT")
    private double credit;


}
