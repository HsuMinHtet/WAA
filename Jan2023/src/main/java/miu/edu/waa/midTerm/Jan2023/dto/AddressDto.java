package miu.edu.waa.midTerm.Jan2023.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.waa.midTerm.Jan2023.domain.Employee;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private String city;
    private String state;
    private String zipCode;

    private EmployeeDto employeeDto;
}
