package Output;

import Exchanges.OutputResponse;

public class PrintResponse {

    public void display(OutputResponse outputResponse){
        System.out.println(outputResponse.getVehicleName()+" "+outputResponse.getOrbitName());
    }
}
