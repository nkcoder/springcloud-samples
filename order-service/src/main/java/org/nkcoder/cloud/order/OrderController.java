package org.nkcoder.cloud.order;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping("")
  public OrderInfo createOrder(@RequestBody @Valid CreateOrderRequest request) {
    return new OrderInfo(orderService.createOrder(request.getProductId(), request.getCount()));
  }
}
