package org.b612foundation.adam.datamodel;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class SinglePropagation extends AdamObject {

  /** Parameters used to generate the ephemeris of this propagation. Null if unknown. */
  private PropagationParameters propagationParameters;

  /** Human-readable description of this propagation. */
  private String description;

  /**
   * Ephemeris produced as part of the propagation. Formatted as contents of STK .e file.
   * 
   * The header contains information about the reference frame of the data, and a UTC timestamp that can be used to
   * interpret the times of the state vectors in the data.
   * 
   * The data section contains cartesian state vector coordinates in meters and meters/second in the metadata reference
   * frame, with times given as seconds offset from the metadata timestamp.
   * 
   * For a complete specification, see http://help.agi.com/stk/index.htm#stk/importfiles-02.htm#formats.
   * 
   * May be null if not requested that ephemeris be kept.
   */
  private String ephemeris;

  /**
   * Calculated state vector at end time as specified in propagation parameters. Equal to the last line of the
   * ephemeris.
   * 
   * Format: time, x, y, z, x velocity, y velocity, z velocity.
   * 
   * Units: seconds-since-file-epoch, meters, meters, meters, meters/second, meters/second, meters/second
   */
  private String finalStateVector;

}