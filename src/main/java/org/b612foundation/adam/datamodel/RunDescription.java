package org.b612foundation.adam.datamodel;


import lombok.Builder;
import lombok.Data;
import org.b612foundation.adam.opm.OrbitParameterMessage;

/**
 * Single run within a batch.
 */
@Data
@Builder
public class RunDescription {
  /** Id of the batch this run is from */
  private String batch_uuid;
  /** Sequential index within the parent batch */
  private int part_index;
  /** State of the calculation for this part. */
  private CalculationState calc_state;
  /** If calc_state is FAILED, error will have more information. */
  private String error;
  /** Full OPM for this particular run. */
  private OrbitParameterMessage opm;
  /** Propagated orbit in STK .e format. Available if calcSate is COMPLETED. */
  private String stk_ephemeris;
  /** Summary for this particular run, both setup and results. */
  private String summary;

}
