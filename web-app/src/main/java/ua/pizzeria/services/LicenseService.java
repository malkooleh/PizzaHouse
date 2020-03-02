package ua.pizzeria.services;

import org.springframework.stereotype.Service;
import ua.pizzeria.clients.OrganizationDiscoveryClient;
import ua.pizzeria.clients.OrganizationRestTemplateClient;
import ua.pizzeria.controller.dto.License;
import ua.pizzeria.controller.dto.Organization;

@Service
public class LicenseService {

    private final OrganizationRestTemplateClient organizationRestClient;

    private final OrganizationDiscoveryClient organizationDiscoveryClient;

    public LicenseService(OrganizationRestTemplateClient organizationRestClient, OrganizationDiscoveryClient organizationDiscoveryClient) {
        this.organizationRestClient = organizationRestClient;
        this.organizationDiscoveryClient = organizationDiscoveryClient;
    }


    private Organization retrieveOrgInfo(String organizationId, String clientType) {
        Organization organization = null;

        switch (clientType) {
            case "feign":
                System.out.println("I am using the feign client");
                break;
            case "rest":
                System.out.println("I am using the rest client");
                organization = organizationRestClient.getOrganization(organizationId);
                break;
            case "discovery":
                System.out.println("I am using the discovery client");
                organization = organizationDiscoveryClient.getOrganization(organizationId);
                break;
            default:
                organization = organizationRestClient.getOrganization(organizationId);
        }

        return organization;
    }

    public License getLicense(String organizationId, String licenseId, String clientType) {
        License license = new License()
                .withOrganizationId(organizationId)
                .withId(licenseId);

        Organization org = retrieveOrgInfo(organizationId, clientType);

        if (org != null) {
            license
                    .withOrganizationName(org.getName())
                    .withContactName(org.getContactName())
                    .withContactEmail(org.getContactEmail())
                    .withContactPhone(org.getContactPhone())
                    .withComment("config.getExampleProperty()");
        }

        return license;
    }

}
