package Adapter.DataProcessor;

import Repository.LengaburuTrafficRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class OrbitDataProcessor implements  DataProcessor {

    public static final String delimiter = ",";

    private LengaburuTrafficRepository lenagburuTrafficRepository;

    public OrbitDataProcessor(LengaburuTrafficRepository lenagburuTrafficRepository) {
        this.lenagburuTrafficRepository = lenagburuTrafficRepository;
    }

    @Override
    public void execute() throws IOException {

        InputStream res = getClass().getClassLoader().getResourceAsStream("Orbits.csv");
        Reader reader = new InputStreamReader(res, java.nio.charset.StandardCharsets.UTF_8);

        BufferedReader br = new BufferedReader(reader);

        String line = "";

        String[] tempArr;

        while ((line = br.readLine()) != null) {
            tempArr = line.split(delimiter);

            String source= tempArr[0];

            String destination = tempArr[1];

            String Orbitname = tempArr[2];

            Integer distance  = Integer.parseInt(tempArr[3]);

            Integer noofcraters = Integer.parseInt(tempArr[4]);

            lenagburuTrafficRepository.addOrbit(source,destination,Orbitname,distance,noofcraters);
        }
        br.close();
    }

}
