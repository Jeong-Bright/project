package database.service;

import database.domain.StudentPrefer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class InfoServiceTest {

    @Autowired
    private InfoService infoService;

    @Test
    void test() {
        Map<String, Optional<StudentPrefer>> studentPreferMap = infoService.departmentPrefer(1L);
        Assertions.assertThat(studentPreferMap.size()).isEqualTo(0);
    }

}