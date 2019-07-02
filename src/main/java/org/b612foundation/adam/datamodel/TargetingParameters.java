package org.b612foundation.adam.datamodel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TargetingParameters {

  /** The distance from earth that should be targeted, in km. */
  private double targetDistanceFromEarth;
  
  /** The distance from earth that should be targeted, in km, during the first stage of targeting */
  @Builder.Default
  private double initialTargetDistanceFromEarth = -1.0;

  /** The tolerance on the targeting of the target distance from earth, in km. */
  private double tolerance;

  /** If true, runs only the nominal propagation of the targeter. If false, runs full targeting. */
  private boolean runNominalOnly;

}
