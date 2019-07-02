package org.b612foundation.adam.opm;

import org.b612foundation.adam.datamodel.PropagatorConfiguration;
import org.junit.Assert;
import org.junit.Test;

public class PropagatorConfigurationTest {

    @Test
    public void basicCreationTest()
    {
        PropagatorConfiguration pc = PropagatorConfiguration.builder().build();
        Assert.assertNotNull(pc);
        Assert.assertEquals(PropagatorConfiguration.PlanetGravityMode.POINT_MASS,pc.getEarth());
    }

    @Test
    public void explicitFieldsCreationTest()
    {
        PropagatorConfiguration pc = PropagatorConfiguration.builder()
                .earth(PropagatorConfiguration.PlanetGravityMode.SPHERICAL_HARMONICS)
                .moon(PropagatorConfiguration.PlanetGravityMode.SPHERICAL_HARMONICS)
                .sun(PropagatorConfiguration.PlanetGravityMode.POINT_MASS)
                .jupiter(PropagatorConfiguration.PlanetGravityMode.POINT_MASS)
                .mars(PropagatorConfiguration.PlanetGravityMode.OMIT)
                .build();

        Assert.assertNotNull(pc);
        Assert.assertEquals(PropagatorConfiguration.PlanetGravityMode.SPHERICAL_HARMONICS, pc.getEarth());
        Assert.assertEquals(PropagatorConfiguration.PlanetGravityMode.SPHERICAL_HARMONICS, pc.getMoon());
        Assert.assertEquals(PropagatorConfiguration.PlanetGravityMode.POINT_MASS, pc.getSun());
        Assert.assertEquals(PropagatorConfiguration.PlanetGravityMode.POINT_MASS, pc.getJupiter());
        Assert.assertEquals(PropagatorConfiguration.PlanetGravityMode.OMIT, pc.getMars());
        Assert.assertEquals(0, pc.getAsteroids().size());
    }
}
