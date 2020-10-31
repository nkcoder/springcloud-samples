package org.nkcoder.cloud.controllers;

import java.util.List;
import org.nkcoder.cloud.services.DiscoveryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tools")
public class ToolsController {

  private final DiscoveryService discoveryService;

  public ToolsController(
      DiscoveryService discoveryService) {
    this.discoveryService = discoveryService;
  }

  @GetMapping(value = "/eureka/services")
  public List<String> getEurekaServices() {

    return discoveryService.getEurekaServices();
  }
}
