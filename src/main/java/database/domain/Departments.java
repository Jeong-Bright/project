package database.domain;

import org.hibernate.service.spi.ServiceException;

import java.lang.reflect.Array;
import java.util.Arrays;


public enum Departments {
    AerospaceEng("항공우주공학과"),
    ArchitecturalEng("건축공학과"),
    CivilEng("토목공학과"),
    ElectricalEng("전기공학과"),
    EnvironmentalEng("환경공학과"),
    IndustrialAndInformationSysEng("산업정보시스템공학과"),
    ItAppliedSystemEng("IT응용시스템공학과"),
    MechanicalEng("기계공학과"),
    MineralResourcesAndEnergyEng("자원에너지공학과"),
    OrganicMaterialsAndFiberEng("유기소재섬유공학과"),
    PolymerNanoScienceAndTech("고분자나노공학과"),
    UrbanEng("도시공학과"),
    ElectronicMaterialsEng("전자재료공학과"),
    IntelligentMaterialsScienceAndEng("정보소재공학과"),
    MetallurgicalSystemEng("금속시스템공학과"),
    BiomedicalEng("바이오메디컬공학과"),
    ChemicalEng("화학공학과"),
    ComputerScienceEng("컴퓨터인공지능공학과"),
    ElectronicEng("전자공학부"),
    MechanicalDesignEng("기계설계공학과"),
    MechanicalSystemEng("기계시스템공학과"),
    SoftwareEngineering("소프트웨어공학과"),
    ConvergenceTechnologyEngineering("IT융합기전공학"),
    QuantumSystemEng("양자시스템공학과"),

    ;


    private String department;

     Departments(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public static Departments converter(String convert){

        return Arrays.stream(Departments.values())
                .filter(v -> v.getDepartment().equals(convert))
                .findAny()
                .orElseThrow(() -> new ServiceException(String.format("상태 코드에 Convert 존재 x")));
    }
}
