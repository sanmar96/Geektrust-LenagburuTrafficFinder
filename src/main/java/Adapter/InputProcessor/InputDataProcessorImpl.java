package Adapter.InputProcessor;

import Exchanges.InputResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class InputDataProcessorImpl implements  InputDataProcessor{

    public static final String delimiter = " ";

    @Override
    public InputResponse execute(String textFile) throws IOException {

        File file = new File(textFile);

        FileReader fr = new FileReader(file);

        BufferedReader br = new BufferedReader(fr);

        String line = "";

        String[] tempArr;

        InputResponse inputResponse = new InputResponse();

        while ((line = br.readLine()) != null) {
            tempArr = line.split(delimiter);

            String Weather= tempArr[0];

            Map<String,Integer> Orbitspeeds = new HashMap<>();

            for(int i=1;i<tempArr.length;++i) {

                String orbitname = "ORBIT"+(i);

                Integer speed = Integer.parseInt(tempArr[i]);

                Orbitspeeds.put(orbitname,speed);
            }
            inputResponse.setWeather(Weather);
            inputResponse.setOrbitspeeds(Orbitspeeds);
        }
        br.close();
        return inputResponse;
    }
}

