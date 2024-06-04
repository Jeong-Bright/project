package database.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany
    @JoinColumn(name = "STUDENT_LECTURE_ID")
    public List<StudentLecture> studentLectures = new ArrayList<>();

    public void addCourse(StudentLecture ... course) {
        Collections.addAll(this.studentLectures, course);
    }

}
