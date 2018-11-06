package gui;

import bl.WeatherBL;
import bl.WeatherStation;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class WeatherCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {

        WeatherStation s = (WeatherStation) o;
        JLabel label = new JLabel();
        label.setOpaque(true);
        if (WeatherBL.show2) {
            switch (i1) {
                case 0:
                    label.setText(s.getPlace());
                    break;
                case 1:
                    label.setText(s.getSealevel() + "m");
                    break;
                case 2:
                    label.setText(s.getTemp() + "°");
                    break;
                case 3:
                    label.setText(s.getHumi() + " %");
                    break;
            }
        } else {
            switch (i1) {
                case 0:
                    label.setText(s.getPlace());
                    break;
                case 1:
                    label.setText(s.getTemp() + "°");
                    break;
                case 2:
                    label.setText(s.getHumi() + " %");
                    break;
            }
        }

        if (s.getTemp() > 25 && s.getHumi() < 20) {
            label.setBackground(Color.YELLOW);
        } else if (s.getTemp() < 0 && s.getHumi() < 30) {
            label.setBackground(Color.BLUE);
        } else if (s.getTemp() > 0 && s.getTemp() < 25 && s.getHumi() > 50) {
            label.setBackground(Color.GREEN);
        } else if (bln) {
            label.setBackground(Color.darkGray);
        }

        return label;

    }

}
