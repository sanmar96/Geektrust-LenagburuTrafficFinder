package Entity;

public class Weather {

    String weatherType;

    Integer craterChangePercentage;

    public Weather(){

    }

    public Weather(String weatherType, Integer craterChangePercentage) {
        this.weatherType = weatherType;
        this.craterChangePercentage = craterChangePercentage;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    public Integer getCraterChangePercentage() {
        return craterChangePercentage;
    }

    public void setCraterChangePercentage(Integer craterChangePercentage) {
        this.craterChangePercentage = craterChangePercentage;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "weatherType='" + weatherType + '\'' +
                ", craterChangePercentage=" + craterChangePercentage +
                '}';
    }
}
