package miu.edu.waa.midTerm.Jan2023.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.waa.midTerm.Jan2023.domain.Address;
import miu.edu.waa.midTerm.Jan2023.domain.Department;
import miu.edu.waa.midTerm.Jan2023.domain.Project;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String name;
    private double salary;
    private AddressDto addressDto;

    private DepartmentDto departmentDto;

    private List<ProjectDto> projectDtoList;
}
