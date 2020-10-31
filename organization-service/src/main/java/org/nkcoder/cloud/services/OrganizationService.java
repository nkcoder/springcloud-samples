package org.nkcoder.cloud.services;

import java.util.UUID;
import org.nkcoder.cloud.model.Organization;
import org.nkcoder.cloud.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

  private final OrganizationRepository orgRepository;

  public OrganizationService(OrganizationRepository orgRepository) {
    this.orgRepository = orgRepository;
  }

  public Organization getOrg(String organizationId) {
    return orgRepository.findById(organizationId).orElseThrow(IllegalArgumentException::new);
  }

  public void saveOrg(Organization org) {
    org.setId(UUID.randomUUID().toString());

    orgRepository.save(org);
  }

  public void updateOrg(Organization org) {
    orgRepository.save(org);
  }

  public void deleteOrg(Organization org) {
    orgRepository.deleteById(org.getId());
  }
}
