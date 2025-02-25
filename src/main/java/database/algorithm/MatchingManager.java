package database.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MatchingManager {

    private Queue<StudentAlgorithm> nonMatching;
    private List<StudentAlgorithm> impossibleMatching;
    
    private List<StudentAlgorithm> matched;

    private DepartmentManager departmentManager;

    private int totalPreference = -1;

    private List<Department> upperCapacity;
    private Queue<Department> lowerCapacity;

    public MatchingManager(List<StudentAlgorithm> studentAlgorithms, List<Department> departments) {
        nonMatching = new LinkedList<>();
        nonMatching.addAll(studentAlgorithms);
        impossibleMatching = new LinkedList<>();
        matched = new LinkedList<>();
        departmentManager = new DepartmentManager(departments);
    }
    
    /**
     * 학생 - 학과 매칭을 수행하고, 매칭된 결과를 반환한다.
     * @param min 학과 별 최소 충족 인원 비율 
     * @param max 학과 별 최대 충족 인원 비율 
     * @return 학과에 매칭된 학생 리스트
     */
    public List<StudentAlgorithm> matching(double min, double max) {
        resetMatching(max);
        while(!nonMatching.isEmpty()) {
            StudentAlgorithm studentAlgorithm = nonMatching.poll();
            int preferNumber = studentAlgorithm.fetchPrefer();
            if(preferNumber < studentAlgorithm.getApplyCount()) {
                preferMatching(studentAlgorithm, preferNumber);
            } else { // n지망까지 모두 떨어졌을 때, 랜덤 매칭
                randomMatching(studentAlgorithm);
            }
        } 
        divide(min);
        return finishMatching();
    }

    public List<StudentAlgorithm> matching() {
        return matching(1.0f, 1.0f);
    }

    /**
     * 선호도 점수 총합을 반환한다. matching()을 먼저 수행해야한다.
     * @return 선호도 점수 총합 (matching() 미 수행 시 -1을 반환)
     */
    public int getTotalPreference() {
        return totalPreference;
    }

    private void resetMatching(double max) {
        nonMatching.addAll(impossibleMatching);
        nonMatching.addAll(matched);
        impossibleMatching.clear();
        matched.clear();

        for(StudentAlgorithm studentAlgorithm : nonMatching) {
            studentAlgorithm.resetMatching();
        }

        departmentManager.resetMatching();
        departmentManager.setMaxCapacityRate(max);

        upperCapacity = new LinkedList<>();
        lowerCapacity = new LinkedList<>();

        totalPreference = 0;   
    }

    private void preferMatching(StudentAlgorithm studentAlgorithm, int preferNumber) {
        Department prefer = departmentManager.findByID(studentAlgorithm.getPreferedDepartmentID(preferNumber));
        if(!prefer.apply(studentAlgorithm, preferNumber)) {
            StudentAlgorithm swapped = prefer.swap(studentAlgorithm, preferNumber);
            nonMatching.add(swapped);
        }
    }

    private void randomMatching(StudentAlgorithm studentAlgorithm) {
        Department random = departmentManager.getAnything();
        if(random != null) { 
            random.apply(studentAlgorithm, StudentAlgorithm.MAX_APPLY);
        } else { // 모든 학과의 정원이 마감인 경우 (== 매칭이 불가능한 학생)
            impossibleMatching.add(studentAlgorithm);
        }
    }

    private void divide(double min) {
        upperCapacity.addAll(departmentManager.getUpperCapacity(min)); // > capacity * min
        lowerCapacity.addAll(departmentManager.getLowerCapacity(min)); // < capacity * min
        for(int prefer = StudentAlgorithm.MAX_APPLY; prefer >= 0; prefer--) {
            for(Department before : upperCapacity) {
                if(!moveStudent(before, prefer, min)) {
                    return;
                }
            }
        }
    }

    private boolean moveStudent(Department before, int prefer, double min) {
        while(before.getApplicants() > before.getCapacity() * min) {
            if(lowerCapacity.isEmpty()) {
                return false;
            }
            Department after = lowerCapacity.peek();
            StudentAlgorithm moved = before.popStudent(prefer);
            if(moved == null) {
                break;
            }
            after.apply(moved, StudentAlgorithm.MAX_APPLY);
            if(after.getApplicants() >= after.getCapacity() * min) {
                lowerCapacity.poll();
            }
        }
        return true;
    }

    private List<StudentAlgorithm> finishMatching() {
        matched.addAll(departmentManager.finishMatching());
        calculateTotalPreference();
        return matched;
    }

    private void calculateTotalPreference() {
        for(StudentAlgorithm match : matched) {
            totalPreference += match.getPreference();
        }
    }
}
