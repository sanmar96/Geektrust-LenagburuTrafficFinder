package Repository;

import Entity.Orbit;
import Entity.Vehicle;

import java.util.List;
import java.util.Map;

public interface LengaburuTrafficRepository {

    public void addVehicle(String Vehicle_type,Integer speed, Integer timeto_cross_crater,
                           List<String>weather_conditions);
    public void addWeather(String weather_type,Integer crater_percentage_change);
    public void addOrbit(String source,String destination,String Orbitname,Integer distance,Integer craters);
    public void setOrbitSpeed(Map<String,Integer> orbitSpeed);
    public List<Vehicle>getAllVehiclesByWeather(String weather);
    public List<Orbit>getAllAvailableOrbits(String source,String destination);
    public Integer getCraterChange(String weather);
}
