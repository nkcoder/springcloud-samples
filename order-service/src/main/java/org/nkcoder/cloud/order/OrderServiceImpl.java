package org.nkcoder.cloud.order;

import java.util.concurrent.ThreadLocalRandom;
import lombok.extern.slf4j.Slf4j;
import org.nkcoder.cloud.stock.AvailableStock;
import org.nkcoder.cloud.stock.StockFeignClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

  private final StockFeignClient stockFeignClient;

  public OrderServiceImpl(StockFeignClient stockFeignClient) {
    this.stockFeignClient = stockFeignClient;
  }

  @Override
  public Long createOrder(Long productId, Integer stocks) {

    AvailableStock availableStock = stockFeignClient.getStocksByProductId(productId);

    if (availableStock == null || availableStock.getCount() < stocks) {
      log.warn("stocks not sufficient for productId: {}", productId);
      throw new IllegalArgumentException("stocks insufficient");
    }

    // create order and send message to deduct the stock

    return ThreadLocalRandom.current().nextLong(10000) + 1;
  }
}
