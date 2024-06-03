package database.repository;

import database.domain.DepartmentString;
import database.domain.Departments;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class DepartmentStringRepositoryTest{

    @Autowired
    DepartmentStringRepository departmentStringRepository;

    @Test
    void test() {
        for(int i = 0; i < 25; i++) {
            Departments departments = Departments.values()[i];
            String department = departments.getDepartment();
            DepartmentString departmentString = new DepartmentString();
            departmentString.setDpt(departments);
            departmentStringRepository.save(departmentString);
        }
    }

}