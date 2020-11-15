package org.nkcoder.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrganizationApplication {

  public static void main(String[] args) {
    SpringApplication.run(OrganizationApplication.class, args);
  }
}
