package miu.edu.waa.midTerm.Jan2023.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emp_id;
    private String name;
    private double salary;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    @JsonManagedReference
    private Address address;
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id")
    @JsonManagedReference
    private Department department;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Employee_Project",
            joinColumns = {@JoinColumn(name="emp_id")},
    inverseJoinColumns = {@JoinColumn(name = "project_id")})
    @JsonManagedReference
    private List<Project> projectList;
}
