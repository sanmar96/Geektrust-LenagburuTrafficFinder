package Model;

public class OrbitModel {

    String source;

    String destination;

    String orbitName;

    Integer distance;

    Integer noOfCraters;

    public OrbitModel(String source, String destination, String orbitName, Integer distance, Integer noOfCraters) {
        this.source = source;
        this.destination = destination;
        this.orbitName = orbitName;
        this.distance = distance;
        this.noOfCraters = noOfCraters;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrbitName() {
        return orbitName;
    }

    public void setOrbitName(String orbitName) {
        this.orbitName = orbitName;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getNoOfCraters() {
        return noOfCraters;
    }

    public void setNoOfCraters(Integer noOfCraters) {
        this.noOfCraters = noOfCraters;
    }

    @Override
    public String toString() {
        return "OrbitModel{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", orbitName='" + orbitName + '\'' +
                ", distance=" + distance +
                ", noOfCraters=" + noOfCraters +
                '}';
    }
}
