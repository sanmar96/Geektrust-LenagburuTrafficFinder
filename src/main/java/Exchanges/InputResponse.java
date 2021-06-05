package Exchanges;

import java.util.HashMap;
import java.util.Map;

public class InputResponse {

    String Weather;

    Map<String,Integer> orbitSpeeds = new HashMap<>();

    public InputResponse(){

    }

    public InputResponse(String weather, Map<String,Integer> orbitSpeeds) {
        Weather = weather;
        this.orbitSpeeds = orbitSpeeds;
    }

    public String getWeather() {
        return Weather;
    }

    public void setWeather(String weather) {
        Weather = weather;
    }

    public Map<String,Integer> getOrbitspeeds() {
        return orbitSpeeds;
    }

    public void setOrbitspeeds(Map<String,Integer> orbitspeeds) {
        this.orbitSpeeds = orbitspeeds;
    }

    @Override
    public String toString() {
        return "InputResponse{" +
                "Weather='" + Weather + '\'' +
                ", orbitspeeds=" + orbitSpeeds +
                '}';
    }
}
