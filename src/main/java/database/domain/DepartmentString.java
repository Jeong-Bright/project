package database.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentString {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Departments dpt;
}
