package ua.pizzeria.clients;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.pizzeria.controller.dto.Organization;

import java.util.List;

@Component
public class OrganizationRestTemplateClient {

    private final RestTemplate restTemplate;

    public OrganizationRestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //annotation is used to wrapper the getLicenseByOrg() method with a Hystrix circuit breaker.
    @HystrixCommand
            (fallbackMethod = "buildFallbackOrganizationList")
            //set the maximum timeout(in milliseconds) a Hystrix call will wait before failing to be 12 seconds
/*            (commandProperties =
                    {@HystrixProperty(
                            name = "execution.isolation.thread.timeoutInMilliseconds",
                            value = "12000")})*/
    public Organization getOrganization(String organizationId) {
        ResponseEntity<Organization> restExchange =
                restTemplate.exchange(
                        "http://organizationservice/v1/organizations/{organizationId}",
                        HttpMethod.GET,
                        null, Organization.class, organizationId);

        return restExchange.getBody();
    }

    private List<Organization> buildFallbackOrganizationList(String organizationId){
        List<Organization> fallbackList = new ArrayList<>();
        Organization organization = new Organization();
        organization.setName("Organization");
        organization.setContactName("Sorry no Organization information currently available");

        fallbackList.add(organization);
        return fallbackList;
    }
}
