package ua.pizzeria.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ua.pizzeria.AppStarter;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = AppStarter.class)
@ComponentScan(value = "ua.pizzeria")
public class AppConfig {

}
