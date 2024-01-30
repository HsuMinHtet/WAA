package miu.edu.waa.midTerm.Jan2023.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.waa.midTerm.Jan2023.domain.Employee;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    private String name;

    private List<EmployeeDto> employeeDtoList;
}
