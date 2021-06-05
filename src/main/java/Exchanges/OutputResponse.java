package Exchanges;

public class OutputResponse {

    String orbitName;

    String vehicleName;

    public OutputResponse() {

    }

    public OutputResponse(String orbitName, String vehicleName) {
        this.orbitName = orbitName;
        this.vehicleName = vehicleName;
    }

    public String getOrbitName() {
        return orbitName;
    }

    public void setOrbitName(String orbitName) {
        this.orbitName = orbitName;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    @Override
    public String toString() {
        return "OutputResponse{" +
                "orbitName='" + orbitName + '\'' +
                ", vehicleName='" + vehicleName + '\'' +
                '}';
    }
}
