package org.b612foundation.adam.datamodel;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Configuration for the interplanetary orbit propagator. Lists various forces to be included.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class PropagatorConfiguration extends AdamObject {

  /**
   * How to include gravity of individual bodies: ignore it all together, use it as point mass, or use a detailed model.
   * For now assume that there is only one "good" spherical harmonics model for each body, so we don't specify which one
   * to use.
   */
  public enum PlanetGravityMode {
    /** Ignore this body's gravity completely. */
    OMIT,
    /** Treat the body as point-mass. */
    POINT_MASS,
    /** Use a spherical harmonics model. Assumes there is a default model. Not always applicable. */
    SPHERICAL_HARMONICS
  }

  /** Human-readable description. Not used in hash code or equal. */
  private String description;

  /** If and how to include Sun gravity. */
  @Builder.Default
  private PlanetGravityMode sun = PlanetGravityMode.POINT_MASS;
  /** If and how to include Mercury gravity. */
  @Builder.Default
  private PlanetGravityMode mercury = PlanetGravityMode.POINT_MASS;
  /** If and how to include Venus gravity. */
  @Builder.Default
  private PlanetGravityMode venus = PlanetGravityMode.POINT_MASS;
  /** If and how to include Earth gravity. */
  @Builder.Default
  private PlanetGravityMode earth = PlanetGravityMode.POINT_MASS;
  /** If and how to include Mars gravity. */
  @Builder.Default
  private PlanetGravityMode mars = PlanetGravityMode.POINT_MASS;
  /** If and how to include Jupiter gravity. */
  @Builder.Default
  private PlanetGravityMode jupiter = PlanetGravityMode.POINT_MASS;
  /** If and how to include Saturn gravity. */
  @Builder.Default
  private PlanetGravityMode saturn = PlanetGravityMode.POINT_MASS;
  /** If and how to include Uranus gravity. */
  @Builder.Default
  private PlanetGravityMode uranus = PlanetGravityMode.POINT_MASS;
  /** If and how to include Neptune gravity. */
  @Builder.Default
  private PlanetGravityMode neptune = PlanetGravityMode.POINT_MASS;
  /** If and how to include Pluto gravity. */
  @Builder.Default
  private PlanetGravityMode pluto = PlanetGravityMode.POINT_MASS;
  /** If and how to include Earth's Moon gravity. */
  @Builder.Default
  private PlanetGravityMode moon = PlanetGravityMode.POINT_MASS;
  /** Names of asteroids we want to include. */
  @Singular
  private List<String> asteroids = new ArrayList<>();

  public String getAsteroidsString() {
    return String.join(",", asteroids);
  }

  public PropagatorConfiguration addAsteroid(String name) {
    asteroids.add(name);
    return this;
  }

  public PropagatorConfiguration setAsteroids(List<String> asteroids) {
    this.asteroids = asteroids;
    return this;
  }

  public PropagatorConfiguration setAsteroidsString(String names) {
    asteroids.clear();
    if (names == null || names.isEmpty()) {
      return this;
    }
    for (String name : names.split(",")) {
      asteroids.add(name.trim());
    }
    return this;
  }

}
