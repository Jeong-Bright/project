package database.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentLecture {


    @Id
    @GeneratedValue
    @Column(name = "COURSE_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "LECTURE_ID")
    private Lecture lecture;
    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

}
