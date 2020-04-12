package org.nkcoder.cloud.stock;

import java.io.Serializable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AvailableStock implements Serializable {

  private static final long serialVersionUID = -4244606859785857722L;

  private final Long productId;
  private final Long count;

}
