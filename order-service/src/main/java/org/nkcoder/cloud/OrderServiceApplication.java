package org.nkcoder.cloud;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class OrderServiceApplication {

  private static final Logger logger = LoggerFactory.getLogger(OrderServiceApplication.class);

  private final ConfigService configService;

  public OrderServiceApplication(ConfigService configService) {
    this.configService = configService;
  }

  public static void main(String[] args) {
    SpringApplication.run(OrderServiceApplication.class, args);
  }

  @PostConstruct
  public void showDataSourceInfo() {
    logger.info("datasource url: {}, username: {}, password: {}", configService.getDataSourceUrl(),
        configService.getDataSourceUserName(), configService.getDataSourcePassword());
  }

}
