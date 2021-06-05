package Controller;

import Config.ApplicationConfig;
import Exchanges.InputResponse;
import Exchanges.OutputResponse;

import java.io.IOException;
import java.util.Map;

public class MainClass {

    public static void main(String[] args) throws IOException {

         var config = new ApplicationConfig();

         var VehicleDataProcessor = config.getVehicleCSVProcessor();

         VehicleDataProcessor.execute();

         var OrbitDataProcessor = config.getOrbitCSVProcessor();

         OrbitDataProcessor.execute();

         var WeatherDataProcessor = config.getWeatherCSVProcessor();

         WeatherDataProcessor.execute();


         var InputDataProcessor = config.getInputDataProcessor();

         String inputTextFile = args[0];

         InputResponse inputResponse = InputDataProcessor.execute(inputTextFile);

         //map which stores the speed of each orbit with key as orbit name.
         Map<String,Integer> orbitSpeeds = inputResponse.getOrbitspeeds();

         //method called to set the orbit speeds to respective orbit where the map is passed as input
         config.setOrbitspeed(orbitSpeeds);

         //method called to find the solution of the problem
         OutputResponse outputResponse = config.lengaburuTrafficSolution(inputResponse.getWeather());

         //calling the display method to print the answer on the console
         var printResponse = config.printTheSolution();

         printResponse.display(outputResponse);


    }
}
