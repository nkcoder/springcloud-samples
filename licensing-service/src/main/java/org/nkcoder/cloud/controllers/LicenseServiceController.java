package org.nkcoder.cloud.controllers;

import java.util.List;
import org.nkcoder.cloud.config.ServiceConfig;
import org.nkcoder.cloud.model.License;
import org.nkcoder.cloud.services.LicenseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

  private final LicenseService licenseService;

  private final ServiceConfig serviceConfig;

  public LicenseServiceController(
      LicenseService licenseService, ServiceConfig serviceConfig) {
    this.licenseService = licenseService;
    this.serviceConfig = serviceConfig;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<License> getLicenses(@PathVariable("organizationId") String organizationId) {

    return licenseService.getLicensesByOrg(organizationId);
  }

  @RequestMapping(value = "/{licenseId}", method = RequestMethod.GET)
  public License getLicenses(@PathVariable("organizationId") String organizationId,
      @PathVariable("licenseId") String licenseId) {

    return licenseService.getLicense(organizationId, licenseId, "");
  }

  @RequestMapping(value = "/{licenseId}/{clientType}", method = RequestMethod.GET)
  public License getLicensesWithClient(@PathVariable("organizationId") String organizationId,
      @PathVariable("licenseId") String licenseId,
      @PathVariable("clientType") String clientType) {

    return licenseService.getLicense(organizationId, licenseId, clientType);
  }

  @RequestMapping(value = "{licenseId}", method = RequestMethod.PUT)
  public void updateLicenses(@PathVariable("licenseId") String licenseId,
      @RequestBody License license) {
    licenseService.updateLicense(license);
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public void saveLicenses(@RequestBody License license) {
    licenseService.saveLicense(license);
  }

  @RequestMapping(value = "{licenseId}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteLicenses(@PathVariable("licenseId") String licenseId,
      @RequestBody License license) {
    licenseService.deleteLicense(license);
  }
}
