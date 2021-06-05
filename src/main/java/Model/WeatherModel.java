package Model;

public class WeatherModel {

    String weatherType;

    Integer craterPercentageChange;

    public WeatherModel(String weatherType, Integer craterPercentageChange) {
        this.weatherType = weatherType;
        this.craterPercentageChange = craterPercentageChange;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    public Integer getCraterPercentageChange() {
        return craterPercentageChange;
    }

    public void setCraterPercentageChange(Integer craterPercentageChange) {
        this.craterPercentageChange = craterPercentageChange;
    }

    @Override
    public String toString() {
        return "WeatherModel{" +
                "weatherType='" + weatherType + '\'' +
                ", craterPercentageChange=" + craterPercentageChange +
                '}';
    }
}
