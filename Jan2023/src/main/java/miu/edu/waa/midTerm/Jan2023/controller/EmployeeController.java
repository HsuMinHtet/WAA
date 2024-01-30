package miu.edu.waa.midTerm.Jan2023.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.waa.midTerm.Jan2023.aop.annotation.Alert;
import miu.edu.waa.midTerm.Jan2023.domain.Employee;
import miu.edu.waa.midTerm.Jan2023.domain.Project;
import miu.edu.waa.midTerm.Jan2023.dto.EmployeeDto;
import miu.edu.waa.midTerm.Jan2023.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    private void createEmployee(@RequestBody EmployeeDto employeeDto) {
        System.out.println(employeeDto);
        employeeService.createEmployee(employeeDto);
    }

    @GetMapping
    private List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}/projects/")
    private List<Project> searchByEmployee(@PathVariable Long id) {
        return employeeService.searchByEmployee(id);
    }

    @GetMapping("/filter/")
    private List<Employee> searchEmployeefilterBylocationAndDepartment(@RequestParam(value = "location", required = true) String location,
                                                                       @RequestParam(value = "department", required = true) Long id) {
        return employeeService.searchEmployeefilterBylocationAndDepartment(location, id);
    }

    @GetMapping("{id}/filter/")
    private List<Project> searhProjectsByEmployeeAndCriteria(@PathVariable Long id,
            @RequestParam(value = "project", required = false) String project,
            @RequestParam(value = "estimateDays", required = false) int estimateDays,
            @RequestParam(value = "location", required = false) String location
    ) {
        List<Project> projectList;
        if (!project.isEmpty() && estimateDays == 0 && !location.isEmpty()) {
            projectList=employeeService.threeANDCriteria(id, project, estimateDays, location);
        }
        if (!project.isEmpty() && estimateDays == 0) {
            projectList=employeeService.criteriaBYProjectANDEstimatDay(id,project, estimateDays);
        }
        if (estimateDays == 0 && location.isEmpty()) {
            projectList=employeeService.criteriaBYEstimatDayANDLocation(id,estimateDays, location);
        }
        if (!project.isEmpty() && location.isEmpty()) {
            projectList=employeeService.criteriaBYProjectANDLocation(id,project, location);
        } else {
            projectList=employeeService.threeORCriteria(id,project, estimateDays, location);
        }
        return projectList;
    }
}
