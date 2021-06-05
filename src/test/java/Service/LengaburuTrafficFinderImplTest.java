package Service;

import Entity.Orbit;
import Entity.Vehicle;
import Exchanges.OutputResponse;
import Repository.LenagburuTrafficRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;


public class LengaburuTrafficFinderImplTest {


    private LenagburuTrafficRepositoryImpl lenagburuTrafficRepository = new LenagburuTrafficRepositoryImpl();

    private LengaburuTrafficFinderImpl lengaburuTrafficFinder = new LengaburuTrafficFinderImpl(lenagburuTrafficRepository);

    @Test
    public void getTrafficFinderSolution(){
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

        lenagburuTrafficRepository.setAvailableVehicles(availableVehicles);

        Map<String, Set<String>> availableSourceOrbits = new HashMap<>();
        Set<String>orbitName = new HashSet<>();
        orbitName.add("ORBIT1");
        orbitName.add("ORBIT2");
        availableSourceOrbits.put("SilkDorb",orbitName);

        lenagburuTrafficRepository.setAvailableSourceOrbits(availableSourceOrbits);


        Map<String,Set<String>> availableDestinationOrbits = new HashMap<>();
        Set<String>orbitName1 = new HashSet<>();
        orbitName1.add("ORBIT1");
        orbitName1.add("ORBIT2");
        availableDestinationOrbits.put("Hallitahram",orbitName1);

        lenagburuTrafficRepository.setAvailableDestinationOrbits(availableDestinationOrbits);


        Map<String, Orbit> availableOrbits = new HashMap<>();
        availableOrbits.put("ORBIT1",new Orbit("SilkDorb","Hallitahram","ORBIT1",18,20,12));
        availableOrbits.put("ORBIT2",new Orbit("SilkDorb","Hallitahram","ORBIT2",20,10,10));


        lenagburuTrafficRepository.setAvailableOrbits(availableOrbits);


        Map<String,Integer> craterChangeByWeather = new HashMap<>();

        craterChangeByWeather.put("SUNNY",-10);

        craterChangeByWeather.put("WINDY",0);

        craterChangeByWeather.put("RAINY",20);

        lenagburuTrafficRepository.setCraterChangeByWeather(craterChangeByWeather);

        OutputResponse outputResponse = new OutputResponse();

        outputResponse.setOrbitName("ORBIT1");

        outputResponse.setVehicleName("TUKTUK");

        Assertions.assertEquals(outputResponse.toString(),lengaburuTrafficFinder.lengaburuTrafficSolution("SUNNY").toString());



    }


}
