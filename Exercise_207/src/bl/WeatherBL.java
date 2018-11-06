package bl;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.AbstractTableModel;

public class WeatherBL extends AbstractTableModel {

    private ArrayList<WeatherStation> stations = new ArrayList<>();
    private static String[] colNames = {"Place", "Sea Level", "Temperature", "rel. Humidity"};
    private static String[] spColNames = {"Place", "Temperature", "rel. Humidity"};
    public static boolean show2 = true;
    
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
    
    public void update(){
        fireTableDataChanged();
    }
    
    public void switchCol(){
        show2 = !show2;
        fireTableStructureChanged();
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
        if(show2) return colNames.length;
        return spColNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return stations.get(rowIndex);
    }
    
    @Override
    public String getColumnName(int i) {
        if(show2) return colNames[i];
        return spColNames[i];
    }
    
}
