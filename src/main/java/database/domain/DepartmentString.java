package database.domain;

import database.domain.converter.DepartmentConverter;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentString {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "DepartmentList", unique = true)
    @Convert(converter = DepartmentConverter.class)
    private Departments dpt;
}
