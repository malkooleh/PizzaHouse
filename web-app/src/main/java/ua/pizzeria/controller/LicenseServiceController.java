package ua.pizzeria.controller;

import org.springframework.web.bind.annotation.*;
import ua.pizzeria.controller.dto.License;
import ua.pizzeria.services.LicenseService;

@RestController
@RequestMapping(value = "v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

    private final LicenseService licenseService;

    public LicenseServiceController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @GetMapping(value = "/{licenseId}")
    public License getLicenses(@PathVariable("organizationId") String organizationId,
                               @PathVariable("licenseId") String licenseId) {

        return licenseService.getLicense(organizationId, licenseId, "");
    }

    @GetMapping(value = "/{licenseId}/{clientType}")
    public License getLicensesWithClient(@PathVariable("organizationId") String organizationId,
                                         @PathVariable("licenseId") String licenseId,
                                         @PathVariable("clientType") String clientType) {

        return licenseService.getLicense(organizationId, licenseId, clientType);
    }

}
