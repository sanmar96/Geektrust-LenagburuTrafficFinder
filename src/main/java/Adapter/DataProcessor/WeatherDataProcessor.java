package Adapter.DataProcessor;

import Repository.LengaburuTrafficRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class WeatherDataProcessor implements  DataProcessor {

    public static final String delimiter = ",";

    private LengaburuTrafficRepository lenagburuTrafficRepository;

    public WeatherDataProcessor(LengaburuTrafficRepository lenagburuTrafficRepository) {
        this.lenagburuTrafficRepository = lenagburuTrafficRepository;
    }

    @Override
    public void execute() throws IOException{
        
        InputStream res = getClass().getClassLoader().getResourceAsStream("Weather.csv");
        Reader reader = new InputStreamReader(res, java.nio.charset.StandardCharsets.UTF_8);

        BufferedReader br = new BufferedReader(reader);

        String line = "";

        String[] tempArr;

        while ((line = br.readLine()) != null) {
            tempArr = line.split(delimiter);

            String weather_type= tempArr[0];

            Integer crater_change_percentage  = Integer.parseInt(tempArr[1]);

            lenagburuTrafficRepository.addWeather(weather_type,crater_change_percentage);
        }
        br.close();
    }
}
