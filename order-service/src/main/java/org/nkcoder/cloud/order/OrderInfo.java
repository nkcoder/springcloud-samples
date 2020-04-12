package org.nkcoder.cloud.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderInfo implements Serializable {

  private static final long serialVersionUID = 7213469187133356084L;

  private final Long orderId;
}
