package miu.edu.waa.midTerm.Jan2023.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dep_id;

    private String name;
    @OneToMany(mappedBy = "department")
    @JsonBackReference
    private List<Employee> employeeList;
}
