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
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long project_id;
    private String name;
    private int estimated_days;
    private String location;
    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "projectList")
    @JsonBackReference
    private List<Employee> employeeList;
}
