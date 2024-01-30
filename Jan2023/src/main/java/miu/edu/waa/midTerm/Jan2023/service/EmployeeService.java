package miu.edu.waa.midTerm.Jan2023.service;

import miu.edu.waa.midTerm.Jan2023.domain.Employee;
import miu.edu.waa.midTerm.Jan2023.domain.Project;
import miu.edu.waa.midTerm.Jan2023.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    void createEmployee(EmployeeDto employeeDto);

    List<Employee> findAll();

    List<Project> searchByEmployee(Long id);

    List<Employee> searchEmployeefilterBylocationAndDepartment(String location, Long id);

    List<Project> threeANDCriteria(Long id, String project, int estimateDays, String location);

    List<Project> criteriaBYProjectANDEstimatDay(Long id, String project, int estimateDays);

    List<Project> criteriaBYEstimatDayANDLocation(Long id,int estimateDays, String location);

    List<Project> criteriaBYProjectANDLocation(Long id, String project, String location);

    List<Project> threeORCriteria(Long id, String project, int estimateDays, String location);
}
