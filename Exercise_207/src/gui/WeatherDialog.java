package gui;


import bl.WeatherStation;
import javax.swing.JOptionPane;

public class WeatherDialog extends javax.swing.JDialog {

    private boolean ok;
    private WeatherStation station;

    public WeatherDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlb1 = new javax.swing.JLabel();
        tfplace = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfsealevel = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tftemp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfhumi = new javax.swing.JTextField();
        btok = new javax.swing.JButton();
        btcancel = new javax.swing.JButton();

        jPanel1.setLayout(new java.awt.GridLayout(5, 2));

        jlb1.setText("Place");
        jPanel1.add(jlb1);
        jPanel1.add(tfplace);

        jLabel2.setText("Sea Level");
        jPanel1.add(jLabel2);
        jPanel1.add(tfsealevel);

        jLabel3.setText("Temperature");
        jPanel1.add(jLabel3);
        jPanel1.add(tftemp);

        jLabel4.setText("rel. Humidity");
        jPanel1.add(jLabel4);
        jPanel1.add(tfhumi);

        btok.setText("OK");
        btok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btokActionPerformed(evt);
            }
        });
        jPanel1.add(btok);

        btcancel.setText("Cancel");
        btcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcancelActionPerformed(evt);
            }
        });
        jPanel1.add(btcancel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btokActionPerformed
        if (tfplace.getText().equals("") || tfsealevel.getText().equals("") || tftemp.getText().equals("") || tfhumi.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
        } else {
            try {
                double temp = Double.parseDouble(tftemp.getText());
                int humi = Integer.parseInt(tfhumi.getText());
                station = new WeatherStation(tfplace.getText(), Integer.parseInt(tfsealevel.getText()), temp, humi);
                ok = true;
                this.dispose();
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Wrong Format!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btokActionPerformed

    private void btcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcancelActionPerformed
        ok = false;
        this.dispose();
    }//GEN-LAST:event_btcancelActionPerformed

    public boolean isOk() {
        return ok;
    }

    public WeatherStation getStation() {
        return station;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcancel;
    private javax.swing.JButton btok;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlb1;
    private javax.swing.JTextField tfhumi;
    private javax.swing.JTextField tfplace;
    private javax.swing.JTextField tfsealevel;
    private javax.swing.JTextField tftemp;
    // End of variables declaration//GEN-END:variables
}
