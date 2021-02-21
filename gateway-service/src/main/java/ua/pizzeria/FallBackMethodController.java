package ua.pizzeria;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/webAppServiceFallBack")
    public String webAppServiceFallBackMethod() {
        return "Web-App Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod() {
        return "User Service is taking longer than Expected." +
                " Please try again later";
    }
}
