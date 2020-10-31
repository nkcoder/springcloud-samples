package org.nkcoder.cloud.controllers;

import java.util.List;
import org.nkcoder.cloud.config.ServiceConfig;
import org.nkcoder.cloud.model.License;
import org.nkcoder.cloud.services.LicenseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

  private final LicenseService licenseService;

  private final ServiceConfig serviceConfig;

  public LicenseServiceController(
      LicenseService licenseService, ServiceConfig serviceConfig) {
    this.licenseService = licenseService;
    this.serviceConfig = serviceConfig;
  }

  @GetMapping("/")
  public List<License> getLicenses(@PathVariable("organizationId") String organizationId) {

    return licenseService.getLicensesByOrg(organizationId);
  }

  @GetMapping("/{licenseId}")
  public License getLicenses(@PathVariable("organizationId") String organizationId,
      @PathVariable("licenseId") String licenseId) {

    return licenseService.getLicense(organizationId, licenseId, "");
  }

  @GetMapping("/{licenseId}/{clientType}")
  public License getLicensesWithClient(@PathVariable("organizationId") String organizationId,
      @PathVariable("licenseId") String licenseId,
      @PathVariable("clientType") String clientType) {

    return licenseService.getLicense(organizationId, licenseId, clientType);
  }

  @GetMapping("{licenseId}")
  public void updateLicenses(@PathVariable("licenseId") String licenseId,
      @RequestBody License license) {
    licenseService.updateLicense(license);
  }

  @PostMapping("/")
  public void saveLicenses(@RequestBody License license) {
    licenseService.saveLicense(license);
  }

  @DeleteMapping("{licenseId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteLicenses(@PathVariable("licenseId") String licenseId,
      @RequestBody License license) {
    licenseService.deleteLicense(license);
  }
}
