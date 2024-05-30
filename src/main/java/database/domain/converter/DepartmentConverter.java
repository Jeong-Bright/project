package database.domain.converter;

import database.domain.Departments;
import jakarta.persistence.AttributeConverter;

public class DepartmentConverter implements AttributeConverter<Departments, String> {
    @Override
    public String convertToDatabaseColumn(Departments attribute) {
        return attribute.getDepartment();
    }

    @Override
    public Departments convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        try {
            return Departments.converter(dbData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
