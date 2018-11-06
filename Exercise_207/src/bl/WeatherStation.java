package bl;


import java.io.Serializable;

public class WeatherStation implements Serializable{
    private String place;
    private int sealevel;
    private double temp;
    private int humi;

    public WeatherStation(String place, int sealevel, double temp, int humi) throws Exception{
        this.place = place;
        this.sealevel = sealevel;
        setTemp(temp);
        setHumi(humi);
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

    public void setTemp(double temp) throws Exception{
        if(temp < -35 || temp > 45) throw new Exception("This Temperature is invalid!");
        this.temp = temp;
    }

    public void setHumi(int humi) throws Exception{
        if(humi < 0 || humi > 100) throw new Exception("This Humidity is invalid!");
        this.humi = humi;
    }
    
    
}
