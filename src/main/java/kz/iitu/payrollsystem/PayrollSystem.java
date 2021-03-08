package kz.iitu.payrollsystem;

import kz.iitu.payrollsystem.config.Config;
import kz.iitu.payrollsystem.dao.EmployeeDao;
import kz.iitu.payrollsystem.service.SalaryCalculatorService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class PayrollSystem {
    public void menuShow() throws SQLException {
        Scanner in = new Scanner(System.in);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        EmployeeDao emplDAO = context.getBean(EmployeeDao.class);

        SalaryCalculatorService service = context.getBean(SalaryCalculatorService.class);

        int choice = -1;

        while (choice != 0) {
            System.out.println("1. Add user to database");
            System.out.println("2. Update salary of users");
            System.out.println("3. List of Employees");
            System.out.println("0. Exit");

            choice = in.nextInt();

            switch (choice) {
                case 1:
                    service.create(emplDAO);
                    break;
                case 2:
                    service.updateSalary(emplDAO);
                    break;
                case 3:
                    service.listOfEmployees(emplDAO);
                    break;
                case 0:
                    return;
            }
        }
    }
}
