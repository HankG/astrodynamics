package org.b612foundation.adam.datamodel;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents a targeted propagation to at least a certain distance from earth.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class TargetedPropagation extends AdamObject {

  /**
   * Parameters used to initialize targeter.
   * 
   * The stopping time should be an estimate of the time of the perigee for which targeting should be run.
   * 
   * The step size will be used for any generated ephemeris files.
   * 
   * The specified OPM may provide a maneuver, which will be used as the initial maneuver for targeting. Currently only
   * maneuvers of 0 seconds and 0 change in mass are supported. The only reference frame currently supported is TNW,
   * which is a local orbital coordinate frame that has the x-axis along the velocity vector, W along the orbital
   * angular momentum vector, and N completes the right handed system.
   */
  private PropagationParameters initialPropagationParameters;

  /**
   * Parameters for the actual targeting.
   */
  private TargetingParameters targetingParameters;

  /** Human-readable description of this object. */
  private String description;

  /**
   * The resulting ephemeris from the targeter. This will be the nominal ephemeris if the targeter is configured to
   * propagate only the nominal trajectory, otherwise the targeted ephemeris.
   */
  private String ephemeris;

  /**
   * The calculated maneuver. Currently will only contain a modification from the initial maneuver in the x-direction.
   */
  private double maneuverX;
  private double maneuverY;
  private double maneuverZ;

}
