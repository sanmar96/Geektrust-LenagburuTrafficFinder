package Service;

import Entity.Orbit;
import Entity.Vehicle;
import Exchanges.OutputResponse;
import Repository.LengaburuTrafficRepository;

import java.util.List;

/**
 * This class contains the solution for the Lengaburu Traffic
 */

public class LengaburuTrafficFinderImpl implements LengaburuTrafficFinder {

    private final LengaburuTrafficRepository lengaburuTrafficRepository;

    public static final String source = "SilkDorb";

    public static final String destination = "Hallitahram";


    public LengaburuTrafficFinderImpl(LengaburuTrafficRepository lengaburuTrafficRepository){

        this.lengaburuTrafficRepository = lengaburuTrafficRepository;
    }

    /**
     * This method is used to get the output response which the orbit and type of vehicle can be used.
     * 1.Get the vehicles available based on the weather conditions.
     * 2.Get the available orbits based on source and destination ,in this Problem there is single source
     * and destination but for scaling purpose in future there might be multiple source and destination and
     * there would only certain no of orbits available
     * 3.Get the crater change as the crater changes with respect to weather
     * 4.Iterate over the available orbits and available vehicles to find the vehicle and the orbit which takes
     * minimum time to reach destination.
     * 5.Time required to cross the orbit will be calculated by time taken to cross the orbit distance and time
     * taken to cross the crater.
     * 6.The vehicle which takes minimum time will be the output.
     */

    @Override
    public OutputResponse lengaburuTrafficSolution(String weather) {

        //get the list of available vehicles by weather
        List<Vehicle> availableVehicles = lengaburuTrafficRepository.getAllVehiclesByWeather(weather);

        //get the list of available orbits by weather
        List<Orbit> availableOrbits = lengaburuTrafficRepository.getAllAvailableOrbits(source,destination);

        //get the crater change percentage with respect to weather
        Integer craterChange = lengaburuTrafficRepository.getCraterChange(weather);

        OutputResponse outputResponse =new OutputResponse();

        //Initialize the time to reach destination as maximum of double value
        double timeTakenToReachDestination = Double.MAX_VALUE;

        for(Orbit orbit:availableOrbits){
            for(Vehicle vehicle:availableVehicles){
                 Integer speed = vehicle.getSpeed();
                 //comparing the vehicle speed with orbit speed ,if vehicle speed is greater then assigning
                 //orbit speed to the vehicle speed
                if(vehicle.getSpeed()> orbit.getOrbitSpeed()){
                    speed = orbit.getOrbitSpeed();
                }

                double craterChangePercentage = craterChange/100.0;
                double noOfCraters = orbit.getNoOfCraters() + (orbit.getNoOfCraters() * craterChangePercentage);


                Integer orbitDistance = orbit.getDistance();

                double timeTakenToCrossOneCraterInHour = vehicle.getTimeToCrossCrater()/60.0;

                double totalTimeTakenToCross = (double)((double)orbitDistance/(speed)) +
                                   (double)((double)noOfCraters*(timeTakenToCrossOneCraterInHour));

                //if total time taken by vehicles are same then the priority must be in the
                // order of bike,tuktuk,car.

                String firstPrioritizedVehicle = "BIKE";

                String secondPrioritizedVehicle = "TUKTUK";

                String thirdPrioritizedVehicle = "CAR";

                if(totalTimeTakenToCross == timeTakenToReachDestination) {
                    if (outputResponse.getVehicleName() == secondPrioritizedVehicle && vehicle.getVehicleName()
                            == firstPrioritizedVehicle) {
                          outputResponse.setVehicleName(vehicle.getVehicleName());
                          outputResponse.setOrbitName(orbit.getOrbitName());
                    }
                    else if (outputResponse.getVehicleName() == thirdPrioritizedVehicle && ((vehicle.getVehicleName()
                            == firstPrioritizedVehicle) ||(vehicle.getVehicleName() == secondPrioritizedVehicle))) {
                        outputResponse.setVehicleName(vehicle.getVehicleName());
                        outputResponse.setOrbitName(orbit.getOrbitName());
                    }
                }

                else if(totalTimeTakenToCross<timeTakenToReachDestination){
                    outputResponse.setVehicleName(vehicle.getVehicleName());
                    outputResponse.setOrbitName(orbit.getOrbitName());
                    timeTakenToReachDestination = totalTimeTakenToCross;
                }

            }
        }

     return outputResponse;
    }
}
