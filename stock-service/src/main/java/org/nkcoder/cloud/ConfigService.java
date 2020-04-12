package org.nkcoder.cloud;

import javax.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Getter
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

  @PostConstruct
  public void showConfigInfo() {
    log.info("datasource url: {}, username: {}, password: {}", getDataSourceUrl(),
        getDataSourceUserName(), getDataSourcePassword());
  }

}
