package kz.iitu.payrollsystem.repository;

import kz.iitu.payrollsystem.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee getById(Integer id);
}
