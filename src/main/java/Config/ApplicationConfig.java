package Config;

import Adapter.DataProcessor.OrbitDataProcessor;
import Adapter.DataProcessor.VehicleDataProcessor;
import Adapter.DataProcessor.WeatherDataProcessor;
import Adapter.InputProcessor.InputDataProcessor;
import Adapter.InputProcessor.InputDataProcessorImpl;
import Exchanges.OutputResponse;
import Output.PrintResponse;
import Repository.LenagburuTrafficRepositoryImpl;
import Repository.LengaburuTrafficRepository;
import Service.LengaburuTrafficFinder;
import Service.LengaburuTrafficFinderImpl;

import java.util.Map;


public class ApplicationConfig {

    private LengaburuTrafficRepository lengaburuTrafficRepository = new LenagburuTrafficRepositoryImpl();

    private LengaburuTrafficFinder lengaburuTrafficFinder =new LengaburuTrafficFinderImpl(lengaburuTrafficRepository);

    public VehicleDataProcessor getVehicleCSVProcessor(){
        return new VehicleDataProcessor(lengaburuTrafficRepository);
    }

    public OrbitDataProcessor getOrbitCSVProcessor(){
        return new OrbitDataProcessor(lengaburuTrafficRepository);
    }

    public WeatherDataProcessor getWeatherCSVProcessor(){
        return new WeatherDataProcessor(lengaburuTrafficRepository);
    }

    public InputDataProcessor getInputDataProcessor(){
        return new InputDataProcessorImpl();
    }

    public void setOrbitspeed( Map<String,Integer> Orbitspeeds){
        lengaburuTrafficRepository.setOrbitSpeed(Orbitspeeds);
    }


    public OutputResponse lengaburuTrafficSolution(String Weather) {
        return lengaburuTrafficFinder.lengaburuTrafficSolution(Weather);
    }

    public PrintResponse printTheSolution(){

        return new PrintResponse();
    }


}
