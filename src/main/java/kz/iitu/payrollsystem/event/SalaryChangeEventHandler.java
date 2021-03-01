package kz.iitu.payrollsystem.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SalaryChangeEventHandler implements ApplicationListener<SalaryChangeEvent> {
    @Override
    public void onApplicationEvent(SalaryChangeEvent salaryChangeEvent) {
        System.out.println("Changing: " + salaryChangeEvent.getEmployee());
    }
}
