package Entity;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class WeatherTest {

    @Test
    public void setWeatherType(){

        Weather weather = new Weather();

        weather.setWeatherType("RAINY");

        Assertions.assertEquals("RAINY",weather.getWeatherType());

    }
    @Test
    public void setCraterChangePercentage(){

        Weather weather = new Weather();

        weather.setCraterChangePercentage(20);

        Assertions.assertEquals((Integer)20,weather.getCraterChangePercentage());

    }
}
