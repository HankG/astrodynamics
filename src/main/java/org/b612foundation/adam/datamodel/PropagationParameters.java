package org.b612foundation.adam.datamodel;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.b612foundation.adam.opm.OdmFormatter;
import org.b612foundation.adam.opm.OdmParseException;
import org.b612foundation.adam.opm.OrbitParameterMessage;

@Data
@NoArgsConstructor
public class PropagationParameters {

  /** Beginning of the ephemerides. Should be UTC. Generated ephemerides will start at this time. */
  private String start_time;
  /** End of the ephemerides. This should be UTC. Generated ephemerides will end at this time. */
  private String end_time;
  /** Time step for the output ephemeris, seconds. If <=0, output will match integrator steps, no interpolation. */
  private long step_duration_sec;
  /** Settings for the numeric propagator - the ID. */
  private String propagator_uuid;
  /** Specific executor to be used, e.g. STK, OpenOrb. The behavior is up to the server implementation. */
  private String executor;
  /** OPM as parsed from a single string in CCSDS format */
  private OrbitParameterMessage opm;
  
  public PropagationParameters deepCopy() {
    PropagationParameters copy = new PropagationParameters();
    copy.setEnd_time(end_time);
    copy.setOpm(opm.deepCopy());
    copy.setPropagator_uuid(propagator_uuid);
    copy.setStart_time(start_time);
    copy.setStep_duration_sec(step_duration_sec);
    copy.setExecutor(executor);
    return copy;
  }

}
