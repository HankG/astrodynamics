package org.b612foundation.adam.datamodel;

import lombok.*;

import java.util.Objects;

/**
 * Post-processing analysis run against a Run or the whole Batch.
 */

@NoArgsConstructor
@ToString
public class Analysis {
  /** Type of this analysis. */
  @Getter @Setter private AnalysisType type;
  /** Id of the batch this analysis is about */
  @Getter @Setter private String batch_uuid;
  /** Run index within that batch, -1 if the whole batch is used (depends on the type of the analysis). */
  @Getter @Setter private int part_index = -1;

  /* TODO some sort of parameter JSON. */

  /** State of the calculation for this analysis. */
  @Getter @Setter private CalculationState calc_state;
  /** If calc_state is FAILED, error will have more information. */
  @Getter @Setter private String error;
  /** Results of the analysis, if COMPLETED. This likely has some internal structure. */
  @Getter @Setter private String result;


  @Override
  public int hashCode() {
    return Objects.hash(type, batch_uuid, part_index);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Analysis other = (Analysis) obj;
    return Objects.equals(type, other.type) && Objects.equals(batch_uuid, other.batch_uuid)
        && Objects.equals(part_index, other.part_index);
  }
}
