package org.nkcoder.cloud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockController {

  private final StockService stockService;

  public StockController(StockService stockService) {
    this.stockService = stockService;
  }

  @GetMapping("/{productId}")
  public AvailableStock getStockByProductId(@PathVariable("productId") Long productId) {
    return new AvailableStock(productId, stockService.getStocksByProductId(productId));
  }

}
