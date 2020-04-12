package org.nkcoder.cloud.stock;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("stockservice")
public interface StockFeignClient {

  @GetMapping("/stocks/{productId}")
  public AvailableStock getStocksByProductId(@PathVariable("productId") Long productId);

}
