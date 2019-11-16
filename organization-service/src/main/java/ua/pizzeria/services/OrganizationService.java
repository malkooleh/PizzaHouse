package ua.pizzeria.services;

import ua.pizzeria.model.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrganizationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationService.class);

    public Organization getOrg(String organizationId) {
        Organization organization = new Organization();
        organization.setContactEmail("ContactEmail");
        organization.setContactName("ContactName");
        organization.setContactPhone("ContactPhone");
        organization.setId(UUID.randomUUID().toString());
        organization.setName("Organization");

        return organization;
    }

    public void saveOrg(Organization org){
        org.setId( UUID.randomUUID().toString());

//        orgRepository.save(org);
        LOGGER.info("orgRepository.save(organization)");

    }

    public void updateOrg(Organization org){
//        orgRepository.save(org);
        LOGGER.info("orgRepository.updateOrg(organization)");
    }

    public void deleteOrg(Organization org){
//        orgRepository.delete( org.getId());
        LOGGER.info("orgRepository.deleteOrg(organization)");
    }
}
