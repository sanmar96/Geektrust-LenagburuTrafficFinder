package Entity;

public class Vehicle {

    String vehicleName;

    Integer speed;

    Integer timeToCrossCrater;

    public Vehicle(){

    }

    public Vehicle(String vehicleName, Integer speed, Integer timeToCrossCrater) {
        this.vehicleName = vehicleName;
        this.speed = speed;
        this.timeToCrossCrater = timeToCrossCrater;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getTimeToCrossCrater() {
        return timeToCrossCrater;
    }

    public void setTimeToCrossCrater(Integer timeToCrossCrater) {
        this.timeToCrossCrater = timeToCrossCrater;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleName='" + vehicleName + '\'' +
                ", speed=" + speed +
                ", timeToCrossCrater=" + timeToCrossCrater +
                '}';
    }
}
