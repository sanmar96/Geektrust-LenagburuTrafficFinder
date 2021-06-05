package Entity;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class VehicleTest {

    @Test
    public void getVehicleName(){

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("TUKTUK");
        Assertions.assertEquals("TUKTUK",vehicle.getVehicleName());
    }
    @Test
    public void getSpeed(){
        Vehicle vehicle = new Vehicle();
        vehicle.setSpeed(20);
        Assertions.assertEquals((Integer)20,vehicle.getSpeed());

    }
    @Test
    public void getTimeToCrossCrater(){
        Vehicle vehicle = new Vehicle();
        vehicle.setTimeToCrossCrater(2);
        Assertions.assertEquals((Integer)2,vehicle.getTimeToCrossCrater());

    }


}
