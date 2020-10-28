package org.nkcoder.cloud.services;

import java.util.List;
import java.util.UUID;
import org.nkcoder.cloud.clients.OrganizationDiscoveryClient;
import org.nkcoder.cloud.clients.OrganizationFeignClient;
import org.nkcoder.cloud.clients.OrganizationRestTemplateClient;
import org.nkcoder.cloud.config.ServiceConfig;
import org.nkcoder.cloud.model.License;
import org.nkcoder.cloud.model.Organization;
import org.nkcoder.cloud.repository.LicenseRepository;
import org.springframework.stereotype.Service;

@Service
public class LicenseService {

  private final LicenseRepository licenseRepository;

  private final ServiceConfig config;

  private final OrganizationFeignClient organizationFeignClient;

  private final OrganizationRestTemplateClient organizationRestClient;

  private final OrganizationDiscoveryClient organizationDiscoveryClient;

  public LicenseService(
      LicenseRepository licenseRepository, ServiceConfig config,
      OrganizationFeignClient organizationFeignClient,
      OrganizationRestTemplateClient organizationRestClient,
      OrganizationDiscoveryClient organizationDiscoveryClient) {
    this.licenseRepository = licenseRepository;
    this.config = config;
    this.organizationFeignClient = organizationFeignClient;
    this.organizationRestClient = organizationRestClient;
    this.organizationDiscoveryClient = organizationDiscoveryClient;
  }


  private Organization retrieveOrgInfo(String organizationId, String clientType) {
    Organization organization = null;

    switch (clientType) {
      case "feign":
        System.out.println("I am using the feign client");
        organization = organizationFeignClient.getOrganization(organizationId);
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
    License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);

    Organization org = retrieveOrgInfo(organizationId, clientType);

    return license
        .withOrganizationName(org.getName())
        .withContactName(org.getContactName())
        .withContactEmail(org.getContactEmail())
        .withContactPhone(org.getContactPhone())
        .withComment(config.getExampleProperty());
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
