package ua.pizzeria.clients;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.pizzeria.controller.dto.Organization;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrganizationRestTemplateClient {

    private final RestTemplate restTemplate;

    public OrganizationRestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //annotation is used to wrapper the getLicenseByOrg() method with a Hystrix circuit breaker.
    @HystrixCommand
            (fallbackMethod = "buildFallbackOrganizationList",
                    threadPoolKey = "getOrganizationThreadPool", //the unique name of thread pool
                    threadPoolProperties = {
                            @HystrixProperty(name = "coreSize", value = "30"), //attribute lets define the maximum number of threads
                            @HystrixProperty(name = "maxQueueSize", value = "10")}, //lets to define a queue that sits in front of your thread pool and that can queue incoming requests
                    //set the maximum timeout(in milliseconds) a Hystrix call will wait before failing to be 12 seconds
                    commandProperties = {
                            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "12000"),
                            //amount of consecutive calls that must occur within a 10-second window
                            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                            //the percentage of calls that must fail
                            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "75"),
                            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "7000"),
                            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "15000"),
                            //collect statistics data into five buckets of three seconds in length (by timeInMilliseconds)
                            @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "5")
                    })
    public Organization getOrganization(String organizationId) {
        ResponseEntity<Organization> restExchange =
                restTemplate.exchange(
                        "http://organizationservice/v1/organizations/{organizationId}",
                        HttpMethod.GET,
                        null, Organization.class, organizationId);

        return restExchange.getBody();
    }

    private List<Organization> buildFallbackOrganizationList(String organizationId) {
        List<Organization> fallbackList = new ArrayList<>();
        Organization organization = new Organization();
        organization.setName("Organization");
        organization.setContactName("Sorry no Organization information currently available");

        fallbackList.add(organization);
        return fallbackList;
    }
}
