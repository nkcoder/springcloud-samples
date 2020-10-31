package org.nkcoder.cloud.controllers;

import org.nkcoder.cloud.model.Organization;
import org.nkcoder.cloud.services.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/organizations")
public class OrganizationServiceController {

  private final OrganizationService orgService;

  public OrganizationServiceController(
      OrganizationService orgService) {
    this.orgService = orgService;
  }

  @GetMapping("/{organizationId}")
  public Organization getOrganization(@PathVariable("organizationId") String organizationId) {
    return orgService.getOrg(organizationId);
  }

  @PutMapping("/{organizationId}")
  public void updateOrganization(@PathVariable("organizationId") String orgId,
      @RequestBody Organization org) {
    orgService.updateOrg(org);
  }

  @PostMapping
  public void saveOrganization(@RequestBody Organization org) {
    orgService.saveOrg(org);
  }

  @DeleteMapping("/{organizationId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteOrganization(@PathVariable("orgId") String orgId,
      @RequestBody Organization org) {
    orgService.deleteOrg(org);
  }
}
