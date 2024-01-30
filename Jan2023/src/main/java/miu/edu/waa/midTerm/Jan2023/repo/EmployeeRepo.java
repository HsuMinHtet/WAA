package miu.edu.waa.midTerm.Jan2023.repo;

import miu.edu.waa.midTerm.Jan2023.domain.Employee;
import miu.edu.waa.midTerm.Jan2023.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    @Query(value = "select e.projectList from Employee e where e.emp_id=:id")
    List<Project> searchByEmployee(Long id);

    @Query(value = "select e from Employee e join e.projectList p where p.location=:location and e.department.dep_id=:id")
    List<Employee> searchEmployeeByLocationAndDepartment(String location, Long id);

    @Query(value = "select e from Employee e join e.projectList p where e.emp_id=:id and p.location = :location OR p.name like :project OR p.estimated_days>= :estimateDays")
    List<Project> threeORCriteria(Long id, String project, int estimateDays, String location);
}
