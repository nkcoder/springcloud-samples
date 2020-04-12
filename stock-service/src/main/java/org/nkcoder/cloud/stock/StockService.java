package org.nkcoder.cloud.stock;

import java.util.concurrent.ThreadLocalRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StockService {

  public Long getStocksByProductId(Long productId) {
    log.info("get stocks for product: {}", productId);
    return ThreadLocalRandom.current().nextLong(10000) + 1;
  }

}
