package bl;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.AbstractTableModel;

public class WeatherBL extends AbstractTableModel {

    private ArrayList<WeatherStation> stations = new ArrayList<>();
    private static String[] colNames = {"Place", "Sea Level", "Temperature", "rel. Humidity"};
    
    public void add(WeatherStation s){
        stations.add(s);
        sortName();
        fireTableDataChanged();
    }
    
    public void delete(int[] idx){
        for (int i = 0; i < idx.length; i++) {
            stations.remove(idx[i]);
        }
        fireTableDataChanged();
    }
    
    public void sortName(){
        Collections.sort(stations, new SortByName());
    }    
    @Override
    public int getRowCount() {
        return stations.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return stations.get(rowIndex);
    }
    
    @Override
    public String getColumnName(int i) {
        return colNames[i];
    }
    
}
