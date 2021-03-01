package kz.iitu.payrollsystem.dao;

import kz.iitu.payrollsystem.model.Employee;
import kz.iitu.payrollsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Component
public class EmployeeDao implements ApplicationEventPublisherAware {

    @Value("${db.url}")
    String url;
    @Value("${db.username}")
    String user;
    @Value("${db.password}")
    String password;
    Connection connection;
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private EmployeeRepository employeeRepository;
    @PostConstruct
    private void initialize() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/madiyar", "madiyar", "123456");
        System.out.println("Connected");
    }

    public Employee create(Employee empl) throws SQLException {
        System.out.println("Created");
        return employeeRepository.save(empl);
    }

    public Employee getEmployee(int id) {
        return employeeRepository.getById(id);
    }

    public void delete(int id) {
        employeeRepository.delete(employeeRepository.getById(id));
        System.out.println("Deleted");
    }

    public void updateSalary(int id, Double salary) {
        Employee empl = employeeRepository.getById(id);
        empl.setSalary(salary);
        employeeRepository.save(empl);
        System.out.println("Updated");
    }

    public List<Employee> getList() {
        return employeeRepository.findAll();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
