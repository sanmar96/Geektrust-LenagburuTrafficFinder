package Repository;

import Entity.Orbit;
import Entity.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.*;


public class LengaburuTrafficRepositoryImplTest {

    LenagburuTrafficRepositoryImpl lengaburuTrafficRepository =new LenagburuTrafficRepositoryImpl();



    @Test
    public void getAllVehiclesByWeather(){


        Map<String, List<Vehicle>> availableVehicles = new HashMap<>();

        List<Vehicle>list = new ArrayList<Vehicle>();

        list.add(new Vehicle("BIKE",10,2));
        list.add(new Vehicle("TUKTUK",12,1));
        list.add(new Vehicle("CAR",20,3));

        availableVehicles.put("SUNNY",list);

        List<Vehicle>list1 = new ArrayList<Vehicle>();
        list1.add(new Vehicle("BIKE",10,2));
        list1.add(new Vehicle("CAR",20,3));

        availableVehicles.put("WINDY",list1);

        List<Vehicle>list2 = new ArrayList<Vehicle>();
        list2.add(new Vehicle("TUKTUK",12,1));
        list2.add(new Vehicle("CAR",20,3));

        availableVehicles.put("RAINY",list2);

        lengaburuTrafficRepository.setAvailableVehicles(availableVehicles);

        List<String> vehicles = new ArrayList<String>();

        vehicles.add("BIKE");

        vehicles.add("TUKTUK");

        vehicles.add("CAR");

        List<Vehicle> vehicleList = lengaburuTrafficRepository.getAllVehiclesByWeather("SUNNY");

        List<String>actualVehcileList = new ArrayList<String>();

        for(Vehicle vehicle:vehicleList){
            actualVehcileList.add(vehicle.getVehicleName());
        }

        Assertions.assertEquals(vehicles,actualVehcileList);

    }


   public void getAllAvailableOrbits(){


        List<String>orbitNames = new ArrayList<String>();
        orbitNames.add("ORBIT1");
        orbitNames.add("ORBIT2");

       Map<String,Set<String>> availableSourceOrbits = new HashMap<>();
       Set<String>orbitName = new HashSet<>();
       orbitName.add("ORBIT1");
       orbitName.add("ORBIT2");
       availableSourceOrbits.put("SilkDorb",orbitName);


       Map<String,Set<String>> availableDestinationOrbits = new HashMap<>();
       Set<String>orbitName1 = new HashSet<>();
       orbitName1.add("ORBIT1");
       orbitName1.add("ORBIT2");
       availableDestinationOrbits.put("Hallitahram",orbitName1);


        Map<String, Orbit> availableOrbits = new HashMap<>();
        availableOrbits.put("ORBIT1",new Orbit("SilkDorb","Hallitahram","ORBIT1",18,20,-1));
        availableOrbits.put("ORBIT2",new Orbit("SilkDorb","Hallitahram","ORBIT2",20,10,-1));


        lengaburuTrafficRepository.setAvailableSourceOrbits(availableSourceOrbits);

        lengaburuTrafficRepository.setAvailableDestinationOrbits(availableDestinationOrbits);

        lengaburuTrafficRepository.setAvailableOrbits(availableOrbits);

       List<Orbit> orbitList = lengaburuTrafficRepository.getAllAvailableOrbits("SilkDorb","Hallitaharam");

       List<String>actualOrbitList = new ArrayList<String>();

       for(Orbit orbit:orbitList){
           actualOrbitList.add(orbit.getOrbitName());
       }


        Assertions.assertEquals(orbitNames,actualOrbitList);
    }

    public void getCraterChangePercentage(){

        Map<String,Integer> craterChangeByWeather = new HashMap<>();

        craterChangeByWeather.put("SUNNY",-10);

        craterChangeByWeather.put("WINDY",0);

        craterChangeByWeather.put("RAINY",20);


        lengaburuTrafficRepository.setCraterChangeByWeather(craterChangeByWeather);

        Assertions.assertEquals((Integer)(-10),lengaburuTrafficRepository.getCraterChange("SUNNY"));

        Assertions.assertEquals((Integer)(0),lengaburuTrafficRepository.getCraterChange("WINDY"));

        Assertions.assertEquals((Integer)(20),lengaburuTrafficRepository.getCraterChange("RAINY"));
    }

}
