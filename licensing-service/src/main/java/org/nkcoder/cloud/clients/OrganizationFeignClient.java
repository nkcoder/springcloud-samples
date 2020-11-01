package org.nkcoder.cloud.clients;


import org.nkcoder.cloud.model.Organization;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("organizationservice")
public interface OrganizationFeignClient {

  @GetMapping(value = "/v1/organizations/{organizationId}", consumes = "application/json")
  Organization getOrganization(@PathVariable("organizationId") String organizationId);
}
