package Repository;

import Entity.Orbit;
import Entity.Vehicle;
import Model.OrbitModel;
import Model.VehicleModel;
import Model.WeatherModel;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;


public class LenagburuTrafficRepositoryImpl implements  LengaburuTrafficRepository {

    Map<String, VehicleModel> vehicleMap = new HashMap<>();

    Map<String, OrbitModel> orbitMap = new HashMap<>();

    Map<String, WeatherModel> weatherMap = new HashMap<>();

    Map<String,Integer> craterChangeByWeather = new HashMap<>();

    Map<String, List<Vehicle>> availableVehicles = new HashMap<>();

    Map<String,Orbit> availableOrbits = new HashMap<>();

    public Map< String, Set<String>> availableSourceOrbits = new HashMap<>();

    Map<String,Set<String>>  availableDestinationOrbits = new HashMap<>();

    public Map<String, Integer> getCraterChangeByWeather() {
        return craterChangeByWeather;
    }

    public void setCraterChangeByWeather(Map<String, Integer> craterChangeByWeather) {
        this.craterChangeByWeather = craterChangeByWeather;
    }

    public Map<String, List<Vehicle>> getAvailableVehicles() {
        return availableVehicles;
    }

    public void setAvailableVehicles(Map<String, List<Vehicle>> availableVehicles) {
        this.availableVehicles = availableVehicles;
    }

    public Map<String, Orbit> getAvailableOrbits() {
        return availableOrbits;
    }

    public void setAvailableOrbits(Map<String, Orbit> availableOrbits) {
        this.availableOrbits = availableOrbits;
    }

    public Map<String, Set<String>> getAvailableSourceOrbits() {
        return availableSourceOrbits;
    }

    public void setAvailableSourceOrbits(Map<String, Set<String>> availableSourceOrbits) {
        this.availableSourceOrbits = availableSourceOrbits;
    }

    public Map<String, Set<String>> getAvailableDestinationOrbits() {
        return availableDestinationOrbits;
    }

    public void setAvailableDestinationOrbits(Map<String, Set<String>> availableDestinationOrbits) {
        this.availableDestinationOrbits = availableDestinationOrbits;
    }


    @Override
    /*
     this method is used to store vehicle details in map with key as vehicle name in Vehicle map and
     weather as key in availableVehicles map.
     */
    public void addVehicle(String vehicleType, Integer speed, Integer timeToCrossCrater, List<String> weatherConditions) {

        vehicleMap.put(vehicleType, new VehicleModel(vehicleType, speed, timeToCrossCrater, weatherConditions));

        for (String weather : weatherConditions) {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleName(vehicleType);
            vehicle.setSpeed(speed);
            vehicle.setTimeToCrossCrater(timeToCrossCrater);
            List<Vehicle> vehicles = new ArrayList<>();
            if (availableVehicles.containsKey(weather)) {
                vehicles = availableVehicles.get(weather);
                vehicles.add(vehicle);
                availableVehicles.put(weather, vehicles);
            } else {
                vehicles.add(vehicle);
                availableVehicles.put(weather, vehicles);
            }
        }

        setAvailableVehicles(availableVehicles);
    }
    @Override

    /*
    1.this method is used to store the orbit details in map Orbit map with orbit name as key
    2.used to store available orbits at source and available orbits at destination.
     */
    public void addOrbit(String source, String destination, String orbitName, Integer distance, Integer craters) {

        orbitMap.put(orbitName,new OrbitModel(source,destination,orbitName,distance,craters));

        Orbit orbit = new Orbit();

        orbit.setSource(source);

        orbit.setDestination(destination);

        orbit.setOrbitName(orbitName);

        orbit.setDistance(distance);

        orbit.setNoOfCraters(craters);

        orbit.setOrbitSpeed(-1);

        Set<String> orbits = new HashSet<>();
        if (availableSourceOrbits.containsKey(source)) {
            orbits = availableSourceOrbits.get(source);
            orbits.add(orbitName);
            availableSourceOrbits.put(source,orbits);
        } else {
            orbits.add(orbitName);
            availableSourceOrbits.put(source,orbits);
        }

        setAvailableSourceOrbits(availableSourceOrbits);

        Set<String> orbits1 = new HashSet<>();
        if (availableDestinationOrbits.containsKey(destination)) {
            orbits1 = availableDestinationOrbits.get(destination);
            orbits1.add(orbitName);
            availableDestinationOrbits.put(destination,orbits1);
        } else {
            orbits1.add(orbitName);
            availableDestinationOrbits.put(destination,orbits1);
        }
        setAvailableDestinationOrbits(availableDestinationOrbits);

        availableOrbits.put(orbitName,orbit);

        setAvailableOrbits(availableOrbits);

    }
  /*
      this method is used to store the crater change percentage for each weather type
   */
    @Override
    public void addWeather(String weatherType, Integer craterPercentageChange) {

        weatherMap.put(weatherType,new WeatherModel(weatherType,craterPercentageChange));

        craterChangeByWeather.put(weatherType,craterPercentageChange);

        setCraterChangeByWeather(craterChangeByWeather);
    }


    /*
    this method is used to set the orbit speed which is taken from the user as input
     */
    @Override
    public void setOrbitSpeed(Map<String, Integer> orbitSpeed) {

        for(String Orbitname:orbitSpeed.keySet()) {

            Orbit orbit = availableOrbits.get(Orbitname);

            orbit.setOrbitSpeed(orbitSpeed.get(Orbitname));

            availableOrbits.put(Orbitname,orbit);

            setAvailableOrbits(availableOrbits);

        }
    }

    /*
    this method is used to return the list of vehicles which can be used based on the weather type.
     */
    @Override
    public List<Vehicle> getAllVehiclesByWeather(String weather) {

        List<Vehicle> listOfVehicles = new ArrayList<>();

        for(String Weather:getAvailableVehicles().keySet()) {
            if(Weather.equals(weather)) {
                listOfVehicles=getAvailableVehicles().get(weather);
            }

        }
        return listOfVehicles;
    }

    /*
    this method is used to return the available orbits which can be used to reach from source to destiantion
     */
    @Override
    public List<Orbit> getAllAvailableOrbits(String source,String destination) {

        Set<String>availableOrbitNames = new HashSet<>();
        for(String Source: getAvailableSourceOrbits().keySet()){

            if(Source.equals(source)) {
                availableOrbitNames =getAvailableSourceOrbits().get(source);
            }
        }

        for(String Destination:getAvailableDestinationOrbits().keySet()){

            if(!Destination.equals(destination)) {
                availableOrbitNames.remove("destination");
            }
        }
        List<Orbit>allAvailableOrbits = new ArrayList<>();

        for(String orbitName:availableOrbitNames){
            allAvailableOrbits.add(getAvailableOrbits().get(orbitName));
        }

        return allAvailableOrbits;
    }

    /*
    this method is used to return crater change percentage for each weather type
     */
    @Override
    public Integer getCraterChange(String weather) {

        return getCraterChangeByWeather().get(weather);

    }
}
