package Controller;

import Config.ApplicationConfig;
import Exchanges.InputResponse;
import Exchanges.OutputResponse;

import java.io.IOException;
import java.util.Map;

public class MainClass {

    public static void main(String[] args) throws IOException {

         ApplicationConfig config = new ApplicationConfig();

         DataProcessor VehicleDataProcessor = config.getVehicleCSVProcessor();

         VehicleDataProcessor.execute();

         DataProcessor  OrbitDataProcessor = config.getOrbitCSVProcessor();

         OrbitDataProcessor.execute();

         DataProcessor WeatherDataProcessor = config.getWeatherCSVProcessor();

         WeatherDataProcessor.execute();

         InputDataProcessor inputDataProcessor = config.getInputDataProcessor();

         String inputTextFile = args[0];

         InputResponse inputResponse = inputDataProcessor.execute(inputTextFile);

         //map which stores the speed of each orbit with key as orbit name.
         Map<String,Integer> orbitSpeeds = inputResponse.getOrbitspeeds();

         //method called to set the orbit speeds to respective orbit where the map is passed as input
         config.setOrbitspeed(orbitSpeeds);

         //method called to find the solution of the problem
         OutputResponse outputResponse = config.lengaburuTrafficSolution(inputResponse.getWeather());

         //calling the display method to print the answer on the console
         PrintResponse printResponse = config.printTheSolution();

         printResponse.display(outputResponse);


    }
}
