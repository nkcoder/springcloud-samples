package org.nkcoder.cloud;

import java.security.SecureRandom;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StockService {

  private static final Random RANDOM = new SecureRandom();

  public Integer getStocksByProductId(Long productId) {
    log.info("get stocks for product: {}", productId);
    return RANDOM.nextInt(1000);
  }

}
