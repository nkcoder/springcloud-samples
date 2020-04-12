package org.nkcoder.cloud.stock;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Getter;

@Getter
public class AvailableStock implements Serializable {

  private static final long serialVersionUID = -4244606859785857722L;

  private final Long productId;
  private final Long count;

  @JsonCreator
  public AvailableStock(
      @JsonProperty("productId") Long productId,
      @JsonProperty("count") Long count) {
    this.productId = productId;
    this.count = count;
  }
}
