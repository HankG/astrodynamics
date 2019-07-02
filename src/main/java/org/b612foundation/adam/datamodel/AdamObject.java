package org.b612foundation.adam.datamodel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class AdamObject {

  /** Id for an object, unique among all AdamObjects. */
  private String uuid;

}
