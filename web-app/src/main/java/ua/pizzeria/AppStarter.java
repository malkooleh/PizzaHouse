package ua.pizzeria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.pizzeria.config.AppConfig;

@SpringBootApplication
public class AppStarter {

    public static void main(String[] args) {
        SpringApplication.run(new Class<?>[]{AppStarter.class, AppConfig.class}, args);
    }
}
