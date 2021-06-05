package Entity;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class OrbitTest {

    @Test
    public void getSourceOfOrbit(){

        Orbit orbit = new Orbit();

        orbit.setSource("SilkDorb");

        Assertions.assertEquals("SilkDorb",orbit.getSource());

    }

    @Test
    public void getDestiantionOfOrbit() {

        Orbit orbit = new Orbit();

        orbit.setDestination("Hallitharam");

        Assertions.assertEquals("Hallitharam",orbit.getDestination());

    }

    @Test
    public void getOrbitName() {

        Orbit orbit = new Orbit();

        orbit.setOrbitName("ORBIT1");

        Assertions.assertEquals("ORBIT1",orbit.getOrbitName());

    }

    public void getDistance() {

        Orbit orbit = new Orbit();

        orbit.setDistance(20);

        Assertions.assertEquals((Integer)20,orbit.getDistance());

    }

     public void getNoOfCraters() {

        Orbit orbit = new Orbit();

        orbit.setNoOfCraters(20);

        Assertions.assertEquals((Integer)20,orbit.getNoOfCraters());

    }

    public void getOrbitSpeed() {

        Orbit orbit = new Orbit();

        orbit.setOrbitSpeed(12);

        Assertions.assertEquals((Integer)12,orbit.getOrbitSpeed());

    }




}
