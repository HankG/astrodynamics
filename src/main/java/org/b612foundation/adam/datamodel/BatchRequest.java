package org.b612foundation.adam.datamodel;

import lombok.*;

/**
 * A request for propagation of one or more runs grouped together. Individual runs are generated from this batch based
 * on parameters specified using OPM extension tags.
 */
@Data
@NoArgsConstructor
public class BatchRequest {

  // Parts specified by the user.
  /** Human-readable description of this batch request. */
  private String description;
  /** Beginning of the ephemerides. Should be UTC. Generated ephemerides will start at this time. */
  private String start_time;
  /** End of the ephemerides. This should be UTC. Generated ephemerides will end at this time. */
  private String end_time;
  /** Time step for the output ephemeris, seconds. If <=0, output will match integrator steps, no interpolation. */
  private long step_duration_sec;
  /** Settings for the numeric propagator - the ID. */
  private String propagator_uuid;
  /** OPM as a single string in CCSDS format */
  private String opm_string;

  // Parts added by the server.
  /** Unique id for a pending batch request, generated on creation. A single request can result in multiple runs. */
  private String uuid;
  /** Total number of parts (individual runs) for this request. */
  private int partsCount = -1;
  /** State of the calculation for the whole batch */
  private CalculationState calcState;
  /** If calc_state is FAILED, error will have more information. */
  private String error;
  /** Summary of the batch results. */
  private String summary;
  /** Batch manager that processes this request. Not used in equals or hashcode. */
  private String manager;

}
