package org.nkcoder.cloud.order;

public interface OrderService {

  Long createOrder(Long productId, Integer stocks);

}
