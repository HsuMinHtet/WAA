package miu.edu.waa.midTerm.Jan2023.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import miu.edu.waa.midTerm.Jan2023.domain.Employee;
import miu.edu.waa.midTerm.Jan2023.domain.Project;
import miu.edu.waa.midTerm.Jan2023.dto.EmployeeDto;
import miu.edu.waa.midTerm.Jan2023.repo.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    private final ModelMapper modelMapper;

    @Override
    public void createEmployee(EmployeeDto employeeDto) {
        employeeRepo.save(modelMapper.map(employeeDto, Employee.class));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public List<Project> searchByEmployee(Long id) {
        return employeeRepo.searchByEmployee(id);
    }

    @Override
    public List<Employee> searchEmployeefilterBylocationAndDepartment(String location, Long id) {
        return employeeRepo.searchEmployeeByLocationAndDepartment(location,id);
    }

    @Override
    public List<Project> threeANDCriteria(Long id,String project, int estimateDays, String location) {
        return null;
    }

    @Override
    public List<Project> criteriaBYProjectANDEstimatDay(Long id,String project, int estimateDays) {
        return null;
    }

    @Override
    public List<Project> criteriaBYEstimatDayANDLocation(Long id,int estimateDays, String location) {
        return null;
    }

    @Override
    public List<Project> criteriaBYProjectANDLocation(Long id,String project, String location) {
        return null;
    }

    @Override
    public List<Project> threeORCriteria(Long id,String project, int estimateDays, String location) {
        return employeeRepo.threeORCriteria(id,project,estimateDays,location);
    }
}
