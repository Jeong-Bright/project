package database.domain;

import database.domain.converter.DepartmentConverter;
import jakarta.persistence.Convert;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {

    @Convert(converter = DepartmentConverter.class)
    private Departments departmentString;

    private String firstPrefer;
    private String secondPrefer;
    private String thirdPrefer;
    private String nonPrefer;


}
