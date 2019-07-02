package org.b612foundation.adam.datamodel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a calculation to compute accesses between the LSST and an asteroid.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class LsstAccessCalculation extends AdamObject {

  /**
   * Parameters to propagate the target asteroid. Either this or asteroidPropagationUuid must be provided.
   */
  private PropagationParameters asteroidPropagationParameters;

  /**
   * Uuid of the propagation of the target asteroid. This will be used if present - otherwise the given propagation
   * parameters will be used to propagate the ephemeris for the target asteroid.
   */
  private String asteroidPropagationUuid;

  /**
   * When to start computing accesses, formatted like an OPM epoch, in UTC. Must be no earlier than the earliest point
   * covered by the asteroid ephemeris.
   */
  private String accessStartTime;

  /**
   * When to stop computing accesses, formatted like an OPM epoch, in UTC. Must be no later than the latest point
   * covered by the asteroid ephemeris.
   */
  private String accessEndTime;

  /**
   * The name of the table in the database from which telescope pointings should be retrieved.
   */
  private String pointingsTableName;

  /** Human-readable description of this object. */
  private String description;

  /**
   * A list of lines describing detected accesses. The format of the line will be
   * "<start_julian_date>,<end_julian_date>;<start_date>,<end_date>", where start_julian_date and end_julian_date are
   * Julian dates and start_date and end_date are ISO-format strings.
   */
  private List<String> accesses;

}
