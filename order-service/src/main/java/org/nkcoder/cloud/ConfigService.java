package org.nkcoder.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigService {

  private final String dataSourceUrl;
  private final String dataSourceUserName;
  private final String dataSourcePassword;

  public ConfigService(@Value("${spring.datasource.url}") String dataSourceUrl,
      @Value("${spring.datasource.username}") String dataSourceUserName,
      @Value("${spring.datasource.password}") String dataSourcePassword) {
    this.dataSourceUrl = dataSourceUrl;
    this.dataSourceUserName = dataSourceUserName;
    this.dataSourcePassword = dataSourcePassword;
  }

  public String getDataSourceUrl() {
    return dataSourceUrl;
  }

  public String getDataSourceUserName() {
    return dataSourceUserName;
  }

  public String getDataSourcePassword() {
    return dataSourcePassword;
  }
}
