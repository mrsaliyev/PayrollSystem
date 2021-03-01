package kz.iitu.payrollsystem.event;

import kz.iitu.payrollsystem.model.Employee;
import org.springframework.context.ApplicationEvent;

public class SalaryChangeEvent extends ApplicationEvent {
    private final Employee empl;

    public SalaryChangeEvent(Object source, Employee empl) {
        super(source);
        this.empl = empl;
    }

    public Employee getEmployee() {
        return empl;
    }
}
