package Model;

import java.util.List;

public class VehicleModel {

    String vehicleName;

    Integer speed;

    Integer timeTakenToCrossCrater;

    List<String>applicableWeatherConditions;

    public VehicleModel(String vehicleName, Integer speed, Integer timeTakenToCrossCrater, List<String> applicableWeatherConditions) {
        this.vehicleName = vehicleName;
        this.speed = speed;
        this.timeTakenToCrossCrater = timeTakenToCrossCrater;
        this.applicableWeatherConditions = applicableWeatherConditions;
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

    public Integer getTimeTakenToCrossCrater() {
        return timeTakenToCrossCrater;
    }

    public void setTimeTakenToCrossCrater(Integer timeTakenToCrossCrater) {
        this.timeTakenToCrossCrater = timeTakenToCrossCrater;
    }

    public List<String> getApplicableWeatherConditions() {
        return applicableWeatherConditions;
    }

    public void setApplicableWeatherConditions(List<String> applicableWeatherConditions) {
        this.applicableWeatherConditions = applicableWeatherConditions;
    }

    @Override
    public String toString() {
        return "VehicleModel{" +
                "vehicleName='" + vehicleName + '\'' +
                ", speed=" + speed +
                ", timeTakenToCrossCrater=" + timeTakenToCrossCrater +
                ", applicableWeatherConditions=" + applicableWeatherConditions +
                '}';
    }
}
