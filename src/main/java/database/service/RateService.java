package database.service;

import database.domain.Departments;
import database.repository.StudentPreferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RateService {

    private final StudentPreferRepository studentPreferRepository;

    @Autowired
    public RateService(StudentPreferRepository studentPreferRepository) {
        this.studentPreferRepository = studentPreferRepository;
    }

    public Map<String , Double> rateCount() {
        Map<String, Double> rateMap = new HashMap<>();
        for (int i = 0; i < 25; i++) {
            Departments value = Departments.values()[i];
            String department = value.getDepartment();
            int i1 = studentPreferRepository.countByFirst(department);
            int i2 = studentPreferRepository.countBySecond(department);
            int i3 = studentPreferRepository.countByThird(department);
            double sum = ((double) (i1 + i2 + i3) / 3000 ) * 100;
//            double cnt = ((double) studentPreferRepository.countByPrefer(department) / 3000) * 100;
            double rate = Math.round(sum);
            rateMap.put(department, rate);
        }
        return rateMap;
    }

}
