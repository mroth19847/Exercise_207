package bl;


import java.io.Serializable;

public class WeatherStation implements Serializable{
    private String place;
    private int sealevel;
    private double temp;
    private int humi;

    public WeatherStation(String place, int sealevel, double temp, int humi) {
        this.place = place;
        this.sealevel = sealevel;
        this.temp = temp;
        this.humi = humi;
    }

    public String getPlace() {
        return place;
    }

    public int getSealevel() {
        return sealevel;
    }

    public double getTemp() {
        return temp;
    }

    public int getHumi() {
        return humi;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setSealevel(int sealevel) {
        this.sealevel = sealevel;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void setHumi(int humi) {
        this.humi = humi;
    }
    
    
}
