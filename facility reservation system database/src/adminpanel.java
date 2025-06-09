
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author USER
 */
public class adminpanel extends javax.swing.JFrame {
private TableRowSorter<DefaultTableModel> sorter;

    public adminpanel() {
       initComponents();
    DefaultTableModel model = (DefaultTableModel) adminTable.getModel();
    sorter = new TableRowSorter<>(model);
    adminTable.setRowSorter(sorter);
    refreshTable();

    // Setup search field placeholder
    jTextField1.setForeground(Color.GRAY);
    jTextField1.setText("Search");

    jTextField1.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
        public void insertUpdate(javax.swing.event.DocumentEvent e) {
            searchFilter();
        }
        public void removeUpdate(javax.swing.event.DocumentEvent e) {
            searchFilter();
        }
        public void changedUpdate(javax.swing.event.DocumentEvent e) {
            searchFilter();
        }
    });
    }


private void refreshTable() {
    List<Reservation> reservations = DatabaseManager.getAllReservations();
    DefaultTableModel model = (DefaultTableModel) adminTable.getModel();
    model.setRowCount(0); // Clear existing rows

    for (Reservation r : reservations) {
        model.addRow(new Object[]{
            r.getUser(), r.getFloor(), r.getRoom(),
            r.getStartTime(), r.getEndTime(), r.getPurpose(),
            new SimpleDateFormat("yyyy-MM-dd").format(r.getDate()),
            r.getStatus()
        });
    }
    tablestyle.centerTableText(adminTable);
        tablestyle.setRoomTableCellRenderer(adminTable, 7);
        tablestyle.styleTableHeader(adminTable);
}
private void searchFilter() {
    String text = jTextField1.getText();
    if (text.trim().length() == 0 || text.equals("Search")) {
        sorter.setRowFilter(null);
    } else {
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        adminTable = new javax.swing.JTable();
        approvereservation = new javax.swing.JButton();
        removereservation = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        refreshbutton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Panel");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(830, 520));
        setPreferredSize(new java.awt.Dimension(830, 520));
        setResizable(false);
        setSize(new java.awt.Dimension(830, 520));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(830, 520));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 153, 0));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Admin Panel");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 180, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Bulldog_Logo.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 200, 140));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(771, 420));

        adminTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Floor", "Room", "Start", "End", "Purpose", "Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(adminTable);
        if (adminTable.getColumnModel().getColumnCount() > 0) {
            adminTable.getColumnModel().getColumn(0).setResizable(false);
            adminTable.getColumnModel().getColumn(1).setResizable(false);
            adminTable.getColumnModel().getColumn(2).setResizable(false);
            adminTable.getColumnModel().getColumn(3).setResizable(false);
            adminTable.getColumnModel().getColumn(4).setResizable(false);
            adminTable.getColumnModel().getColumn(6).setResizable(false);
            adminTable.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 717, 240));

        approvereservation.setBackground(new java.awt.Color(0, 153, 0));
        approvereservation.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        approvereservation.setForeground(new java.awt.Color(255, 255, 255));
        approvereservation.setText("Approve Reservation");
        approvereservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approvereservationActionPerformed(evt);
            }
        });
        jPanel1.add(approvereservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 196, 20));

        removereservation.setBackground(new java.awt.Color(255, 102, 102));
        removereservation.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        removereservation.setForeground(new java.awt.Color(255, 255, 255));
        removereservation.setText("Remove Reservation");
        removereservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removereservationActionPerformed(evt);
            }
        });
        jPanel1.add(removereservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 220, 20));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField1.setText("Search");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 133, 30));

        refreshbutton.setText("Refresh");
        refreshbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(refreshbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 130, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo background.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 110));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 19)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setText("NATIONAL");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 210, 40));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 19)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("UNIVERSITY");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 210, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void approvereservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approvereservationActionPerformed
       int row = adminTable.getSelectedRow();
    if (row == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please select a reservation to approve.");
        return;
    }

    String username = (String) adminTable.getValueAt(row, 0);
    String floor = (String) adminTable.getValueAt(row, 1);
    String room = (String) adminTable.getValueAt(row, 2);
    String start = (String) adminTable.getValueAt(row, 3);
    String end = (String) adminTable.getValueAt(row, 4);
    String purpose = (String) adminTable.getValueAt(row, 5);
    String dateStr = (String) adminTable.getValueAt(row, 6);

    // Find reservation ID
    List<Reservation> reservations = DatabaseManager.getAllReservations();
    for (Reservation r : reservations) {
        if (r.getUser().equals(username) && r.getFloor().equals(floor) &&
            r.getRoom().equals(room) && r.getStartTime().equals(start) &&
            r.getEndTime().equals(end) && r.getPurpose().equals(purpose) &&
            new SimpleDateFormat("yyyy-MM-dd").format(r.getDate()).equals(dateStr)) {

                    if (DatabaseManager.approveReservation(r.getId())) {
            // Update room status to "Reserved"
            boolean updated = DatabaseManager.updateRoomStatus(r.getRoom(), r.getFloor(), "Reserved");

            if (updated) {
                javax.swing.JOptionPane.showMessageDialog(this, "Reservation approved and room marked as reserved.");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Reservation approved, but failed to update room status.");
            }
                    }
            return;
        }
    }

    javax.swing.JOptionPane.showMessageDialog(this, "Reservation not found.");
    }//GEN-LAST:event_approvereservationActionPerformed

    private void removereservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removereservationActionPerformed

            int row = adminTable.getSelectedRow();
    if (row == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please select a reservation to remove.");
        return;
    }

    String username = (String) adminTable.getValueAt(row, 0);
    String floor = (String) adminTable.getValueAt(row, 1);
    String room = (String) adminTable.getValueAt(row, 2);
    String start = (String) adminTable.getValueAt(row, 3);
    String end = (String) adminTable.getValueAt(row, 4);
    String purpose = (String) adminTable.getValueAt(row, 5);
    String dateStr = (String) adminTable.getValueAt(row, 6);

    List<Reservation> reservations = DatabaseManager.getAllReservations();
    for (Reservation r : reservations) {
        if (r.getUser().equals(username) && r.getFloor().equals(floor) &&
            r.getRoom().equals(room) && r.getStartTime().equals(start) &&
            r.getEndTime().equals(end) && r.getPurpose().equals(purpose) &&
            new SimpleDateFormat("yyyy-MM-dd").format(r.getDate()).equals(dateStr)) {

            if (DatabaseManager.deleteReservation(r.getId())) {
                // Reset room status to "Available"
                boolean statusReset = DatabaseManager.updateRoomStatus(room, floor, "Available");

                if (statusReset) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Reservation removed and room marked as available.");
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Reservation removed but failed to update room status.");
                }
                refreshTable();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Failed to remove reservation.");
            }
            return;
        }
    }

    javax.swing.JOptionPane.showMessageDialog(this, "Reservation not found.");
   
    }//GEN-LAST:event_removereservationActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
    if (jTextField1.getText().equals("Search")) {
        jTextField1.setText("");
        jTextField1.setForeground(Color.BLACK);
    }
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
    if (jTextField1.getText().isEmpty()) {
        jTextField1.setForeground(Color.GRAY);
        jTextField1.setText("Search");
    }
    }//GEN-LAST:event_jTextField1FocusLost

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
     
    
    }//GEN-LAST:event_jLabel3MouseClicked

    private void refreshbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshbuttonActionPerformed
        refreshTable();
    }//GEN-LAST:event_refreshbuttonActionPerformed

    private void addtextfieldplaceholder(JTextField textField) {
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable adminTable;
    private javax.swing.JButton approvereservation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton refreshbutton;
    private javax.swing.JButton removereservation;
    // End of variables declaration//GEN-END:variables
}
