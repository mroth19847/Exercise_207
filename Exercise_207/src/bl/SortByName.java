package bl;

import java.util.Comparator;

public class SortByName implements Comparator<WeatherStation>{

    @Override
    public int compare(WeatherStation o1, WeatherStation o2) {
        return o1.getPlace().compareTo(o2.getPlace());
    }

    
}
