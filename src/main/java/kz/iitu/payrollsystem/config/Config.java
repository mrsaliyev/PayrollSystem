package kz.iitu.payrollsystem.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("kz.iitu.payrollsystem")
@PropertySource("application.properties")
public class Config {
}
