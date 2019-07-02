package org.b612foundation.adam.datamodel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class BatchPropagation extends AdamObject {

  /** Parameters used to generate the ephemerides of propagations in this batch. */
  private PropagationParameters templatePropagationParameters;

  /** Human-readable description of this object. */
  private String description;

  /** Summary of the results. */
  private String summary;

}
