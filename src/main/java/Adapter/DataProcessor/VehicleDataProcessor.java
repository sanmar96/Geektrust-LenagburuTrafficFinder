package Adapter.DataProcessor;

import Repository.LengaburuTrafficRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VehicleDataProcessor implements DataProcessor {

    public static final String delimiter = ",";

    private LengaburuTrafficRepository lenagburuTrafficRepository;

    public VehicleDataProcessor(LengaburuTrafficRepository lenagburuTrafficRepository) {
        this.lenagburuTrafficRepository = lenagburuTrafficRepository;
    }

    @Override
    public void execute() throws IOException{

        InputStream res = getClass().getClassLoader().getResourceAsStream("Vehicle.csv");
        Reader reader = new InputStreamReader(res, java.nio.charset.StandardCharsets.UTF_8);

        BufferedReader br = new BufferedReader(reader);

        String line = "";

        String[] tempArr;

        while ((line = br.readLine()) != null) {
            tempArr = line.split(delimiter);

            String vehicle_name= tempArr[0];

            Integer speed = Integer.parseInt(tempArr[1]);

            Integer time_to_cross_crater = Integer.parseInt(tempArr[2]);

            List<String> listofweather = new ArrayList<String>();

            listofweather = Arrays.asList(tempArr[3].split(" "));

            lenagburuTrafficRepository.addVehicle(vehicle_name,speed,time_to_cross_crater,listofweather);
        }
        br.close();
    }

}
