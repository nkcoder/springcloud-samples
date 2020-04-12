package org.nkcoder.cloud.order;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateOrderRequest implements Serializable {

  private static final long serialVersionUID = -6545039177332390647L;

  @NotNull
  private final Long productId;
  @Min(1)
  private final Integer count;

  @JsonCreator
  public CreateOrderRequest(@JsonProperty("productId") Long productId,
      @JsonProperty("count") Integer count) {
    this.productId = productId;
    this.count = count;
  }
}
