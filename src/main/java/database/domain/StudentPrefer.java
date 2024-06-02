package database.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class StudentPrefer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PREFER_ID")
    private Long id;
    @Column(name = "PREFER_FIRST")
    private String first;
    @Column(name = "PREFER_SECOND")
    private String second;
    @Column(name = "PREFER_THIRD")
    private String third;
    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    public StudentPrefer() {

    }

    public void editPrefer(String first, String second, String third, Student student) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.student = student;
    }
}
