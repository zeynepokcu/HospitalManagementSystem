/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Zeynep
 */
public class Module3 extends javax.swing.JFrame {

    DefaultTableModel dm;

    private int appointmentID;
    private String polyclinic;
    private String doctor;
    private String date;
    private String time;
    private String tcNo;
    private String firstName;
    private String lastName;

    public int getAppointmentID() {
        appointmentID = Integer.parseInt(jTextField1.getText());
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getPolyclinic() {
        polyclinic = (String) jComboBox1.getSelectedItem();
        return polyclinic;
    }

    public void setPolyclinic(String polyclinic) {
        this.polyclinic = polyclinic;
    }

    public String getDoctor() {
        doctor = (String) jComboBox2.getSelectedItem();
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date = sdf.format(jDateChooser1.getDate());
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        time = jTextField2.getText();
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTcNo() {
        tcNo = jTextField3.getText();
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getFirstName() {
        firstName = jTextField4.getText();
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        lastName = jTextField5.getText();
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Creates new form Module1
     */
    public Module3() {
        initComponents();
        CreateColumns();
        setExtendedState(Module3.MAXIMIZED_BOTH);
        Color background = new Color(236, 242, 246);
        this.getContentPane().setBackground(background);
        showAppointmentTable();
        showDoctors();
        showPolyclinics();
    }

    private void CreateColumns() {
        dm = (DefaultTableModel) appointmentTable.getModel();
        appointmentTable.setModel(dm);
        //add columns
        dm.addColumn("ID");
        dm.addColumn("Poliklinik");
        dm.addColumn("Doktor");
        dm.addColumn("Tarih");
        dm.addColumn("Saat");
        dm.addColumn("Hasta TC No");
        dm.addColumn("Hasta Adı");
        dm.addColumn("Hasta Soyadı");

    }

    public void showAppointmentTable() {
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "SELECT * FROM Appointments";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            DefaultTableModel tm = (DefaultTableModel) appointmentTable.getModel();
            tm.setRowCount(0);

            while (rs.next()) {
                Object o[] = {rs.getInt("appointmentID"), rs.getString("polyclinic"), rs.getString("doctor"), rs.getDate("date"), rs.getTime("time"), rs.getString("patientTC"), rs.getString("patientName"), rs.getString("patientSurname")};
                tm.addRow(o);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void showDoctors() {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement stat = con.createStatement();
            String query = "SELECT CONCAT(doctorName ,' ',doctorSurname ) AS fullName FROM Doctors";
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                jComboBox2.addItem(rs.getString("fullName"));
            }
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void showPolyclinics() {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement stat = con.createStatement();
            String query = "SELECT polyclinicName FROM Polyclinics";
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                jComboBox1.addItem(rs.getString("polyclinicName"));
            }
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pname = new javax.swing.JLabel();
        fname = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        appointmentTable = new javax.swing.JTable();
        deleteAppointment = new javax.swing.JButton();
        updateAppointment = new javax.swing.JButton();
        searchAppointment = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Randevu Kayıtları");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1920, 1000));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(61, 76, 143));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Randevu Kayıtları");

        pname.setText("Randevu Tarihi: ");
        pname.setAlignmentX(0.5F);

        fname.setText("Hasta TC No:");
        fname.setAlignmentX(0.5F);

        jLabel5.setText("Randevu ID:");
        jLabel5.setAlignmentX(0.5F);

        backButton.setText("GERİ");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });

        jLabel3.setText("Hasta Soyad:");
        jLabel3.setAlignmentX(0.5F);

        jLabel8.setText("Doktor:");
        jLabel8.setAlignmentX(0.5F);

        jLabel11.setText("Poliklinik:");
        jLabel11.setAlignmentX(0.5F);

        jLabel13.setText("Hasta Ad:");
        jLabel13.setAlignmentX(0.5F);

        appointmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        appointmentTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        appointmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointmentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(appointmentTable);

        deleteAppointment.setText("Sil");
        deleteAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAppointmentActionPerformed(evt);
            }
        });

        updateAppointment.setText("Güncelle");
        updateAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateAppointmentActionPerformed(evt);
            }
        });

        searchAppointment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchAppointmentKeyReleased(evt);
            }
        });

        jLabel10.setText("Aramak istediğiniz randevunun ID numarasını giriniz:");

        jLabel4.setText("Randevu Saati:");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 220, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(60, 60, 60))
                    .addComponent(jLabel4)
                    .addComponent(pname))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(jLabel9))
                            .addComponent(searchAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(deleteAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(467, 467, 467))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addComponent(jLabel2))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pname)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(updateAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        MenuPage obj = new MenuPage();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_backButtonMouseClicked

    private void appointmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentTableMouseClicked
        jTextField1.setText(appointmentTable.getValueAt(appointmentTable.getSelectedRow(), 0).toString());
        jComboBox1.setSelectedItem(appointmentTable.getValueAt(appointmentTable.getSelectedRow(), 1).toString());
        jComboBox2.setSelectedItem(appointmentTable.getValueAt(appointmentTable.getSelectedRow(), 2).toString());
        int getSelectedRowForUpdate = appointmentTable.getSelectedRow();

        String val = (String) appointmentTable.getValueAt(getSelectedRowForUpdate, 3);
        java.util.Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(val);
        } catch (ParseException ex) {
            Logger.getLogger(Module1.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDateChooser1.setDate(date);
        jTextField2.setText(appointmentTable.getValueAt(appointmentTable.getSelectedRow(), 4).toString());
        jTextField3.setText(appointmentTable.getValueAt(appointmentTable.getSelectedRow(), 5).toString());
        jTextField4.setText(appointmentTable.getValueAt(appointmentTable.getSelectedRow(), 6).toString());
        jTextField5.setText(appointmentTable.getValueAt(appointmentTable.getSelectedRow(), 7).toString());
    }//GEN-LAST:event_appointmentTableMouseClicked

    private void deleteAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAppointmentActionPerformed
        try {
            String sql = "DELETE FROM Appointments WHERE appointmentID=?";
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, getAppointmentID());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Başarıyla silindi!");
            jTextField1.setText(null);
            jTextField2.setText(null);
            jTextField3.setText(null);
            jTextField4.setText(null);
            jTextField5.setText(null);
            jComboBox1.setSelectedIndex(0);
            jComboBox2.setSelectedIndex(0);
            jDateChooser1.setDate(null);
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        showAppointmentTable();
    }//GEN-LAST:event_deleteAppointmentActionPerformed

    private void updateAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateAppointmentActionPerformed
        try {
            String sql = "UPDATE Appointments SET appointmentID='" + getAppointmentID() + "',polyclinic='" + getPolyclinic() + "',doctor='" + getDoctor() + "',date='" + getDate() + "',time='" + getTime() + "',patientTC='" + getTcNo() + "',patientName ='" + getFirstName() + "',patientSurname='" + getLastName() + "' WHERE appointmentID='" + getAppointmentID() + "'";
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Başarıyla güncellendi!");
            jTextField1.setText(null);
            jTextField2.setText(null);
            jTextField3.setText(null);
            jTextField4.setText(null);
            jTextField5.setText(null);
            jComboBox1.setSelectedIndex(0);
            jComboBox2.setSelectedIndex(0);
            jDateChooser1.setDate(null);
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        showAppointmentTable();
    }//GEN-LAST:event_updateAppointmentActionPerformed

    private void searchAppointmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchAppointmentKeyReleased
        dm = (DefaultTableModel) appointmentTable.getModel();
        String search = searchAppointment.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
        appointmentTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_searchAppointmentKeyReleased

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Module3.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Module3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTable appointmentTable;
    private javax.swing.JButton backButton;
    private javax.swing.JButton deleteAppointment;
    private javax.swing.JLabel fname;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel pname;
    private javax.swing.JTextField searchAppointment;
    private javax.swing.JButton updateAppointment;
    // End of variables declaration//GEN-END:variables

    private static class module1 {

        public module1() {
        }

        private void setVisible(boolean b) {

        }
    }

    private static class DbUtils {

        private static TableModel resultSetToTableModel(ResultSet rs) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public DbUtils() {
        }
    }

}
