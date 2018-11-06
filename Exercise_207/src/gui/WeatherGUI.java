package gui;

import bl.WeatherBL;
import bl.WeatherStation;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class WeatherGUI extends javax.swing.JFrame {

    private WeatherBL bl = new WeatherBL();

    public WeatherGUI() {
        initComponents();
        WeatherTable.setModel(bl);
        WeatherTable.setDefaultRenderer(Object.class, new WeatherCellRenderer());
        try {
            bl.loadSerialize(new File("./stations.ser"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        btremoveCol = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        WeatherTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        btStations = new javax.swing.JMenu();
        btadd = new javax.swing.JMenuItem();
        btremove = new javax.swing.JMenuItem();
        btValues = new javax.swing.JMenu();
        bttemp = new javax.swing.JMenuItem();
        bthumi = new javax.swing.JMenuItem();

        btremoveCol.setText("Show / Dispose Sea Level");
        btremoveCol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btremoveColActionPerformed(evt);
            }
        });
        jPopupMenu1.add(btremoveCol);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        WeatherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(WeatherTable);

        btStations.setText("Stations");

        btadd.setText("Add Weather Station");
        btadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaddActionPerformed(evt);
            }
        });
        btStations.add(btadd);

        btremove.setText("Remove Weather Station");
        btremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btremoveActionPerformed(evt);
            }
        });
        btStations.add(btremove);

        jMenuBar1.add(btStations);

        btValues.setText("Values");

        bttemp.setText("Set Temperature");
        bttemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttempActionPerformed(evt);
            }
        });
        btValues.add(bttemp);

        bthumi.setText("Set Humidity");
        bthumi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthumiActionPerformed(evt);
            }
        });
        btValues.add(bthumi);

        jMenuBar1.add(btValues);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaddActionPerformed
        WeatherDialog dlg = new WeatherDialog(this, true);
        dlg.setVisible(true);
        if (dlg.isOk()) {
            bl.add(dlg.getStation());
        }
    }//GEN-LAST:event_btaddActionPerformed

    private void btremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btremoveActionPerformed
        int[] sel = WeatherTable.getSelectedRows();
        bl.delete(sel);
    }//GEN-LAST:event_btremoveActionPerformed

    private void bttempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttempActionPerformed
        try {
            int sel = WeatherTable.getSelectedRow();
            if (sel > -1) {
                ((WeatherStation) bl.getValueAt(sel, 0)).setTemp(Double.parseDouble(JOptionPane.showInputDialog("Please input temperature")));
            }
            bl.update();
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Invalid Format!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_bttempActionPerformed

    private void bthumiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthumiActionPerformed
        try {
            int sel = WeatherTable.getSelectedRow();
            if (sel > -1) {
                ((WeatherStation) bl.getValueAt(sel, 0)).setHumi(Integer.parseInt(JOptionPane.showInputDialog("Please input humidity")));
            }
            bl.update();
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Invalid Format!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_bthumiActionPerformed

    private void btremoveColActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btremoveColActionPerformed
        bl.switchCol();
    }//GEN-LAST:event_btremoveColActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            bl.saveSerialize(new File("./stations.ser"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WeatherGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable WeatherTable;
    private javax.swing.JMenu btStations;
    private javax.swing.JMenu btValues;
    private javax.swing.JMenuItem btadd;
    private javax.swing.JMenuItem bthumi;
    private javax.swing.JMenuItem btremove;
    private javax.swing.JMenuItem btremoveCol;
    private javax.swing.JMenuItem bttemp;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
