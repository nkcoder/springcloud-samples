package org.nkcoder.cloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig{

  @Value("${example.property: hello}")
  private String exampleProperty="";

  public String getExampleProperty(){
    return exampleProperty;
  }
}
