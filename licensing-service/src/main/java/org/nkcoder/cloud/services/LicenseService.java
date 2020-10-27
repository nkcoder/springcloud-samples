package org.nkcoder.cloud.services;

import java.util.List;
import java.util.UUID;
import org.nkcoder.cloud.config.ServiceConfig;
import org.nkcoder.cloud.model.License;
import org.nkcoder.cloud.repository.LicenseRepository;
import org.springframework.stereotype.Service;

@Service
public class LicenseService {

  private final LicenseRepository licenseRepository;

  private final ServiceConfig config;

  public LicenseService(LicenseRepository licenseRepository, ServiceConfig config) {
    this.licenseRepository = licenseRepository;
    this.config = config;
  }

  public License getLicense(String organizationId, String licenseId) {
    License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
    return license.withComment(config.getExampleProperty());
  }

  public List<License> getLicensesByOrg(String organizationId) {
    return licenseRepository.findByOrganizationId(organizationId);
  }

  public void saveLicense(License license) {
    license.withId(UUID.randomUUID().toString());

    licenseRepository.save(license);

  }

  public void updateLicense(License license) {
    licenseRepository.save(license);
  }

  public void deleteLicense(License license) {
    licenseRepository.deleteById(license.getLicenseId());
  }

}
