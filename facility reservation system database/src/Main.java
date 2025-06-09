
import com.formdev.flatlaf.FlatDarkLaf;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Main extends javax.swing.JFrame {

private String loggedInUsername = null;

public Main() {
    initComponents(); // must call this first to init the UI components
    loadRoomsIntoTable();
    refreshbutton.setVisible(false);
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomTableModel = new javax.swing.JTable();
        registerbutton = new javax.swing.JButton();
        loginbutton = new javax.swing.JButton();
        cancelreservationbutton = new javax.swing.JButton();
        reservationbutton = new javax.swing.JButton();
        refreshbutton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        pendingReservationsTable = new javax.swing.JTable();
        SecretButtonAdmin = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setAlwaysOnTop(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Available Rooms");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 260, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Bulldog_Logo.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 200, 140));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        roomTableModel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"PE Room", null, null},
                {"Computer Lab", null, null},
                {"501", null, null},
                {"502", null, null},
                {"503", null, null}
            },
            new String [] {
                "Room", "Floor", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        roomTableModel.setToolTipText("");
        roomTableModel.setGridColor(new java.awt.Color(0, 0, 0));
        roomTableModel.setSelectionBackground(new java.awt.Color(147, 147, 248));
        roomTableModel.getTableHeader().setReorderingAllowed(false);
        roomTableModel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                roomTableModelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                roomTableModelFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(roomTableModel);
        if (roomTableModel.getColumnModel().getColumnCount() > 0) {
            roomTableModel.getColumnModel().getColumn(0).setHeaderValue("Room");
            roomTableModel.getColumnModel().getColumn(1).setResizable(false);
            roomTableModel.getColumnModel().getColumn(1).setHeaderValue("Floor");
            roomTableModel.getColumnModel().getColumn(2).setResizable(false);
            roomTableModel.getColumnModel().getColumn(2).setHeaderValue("Status");
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 320, 320));

        registerbutton.setBackground(new java.awt.Color(102, 102, 102));
        registerbutton.setForeground(new java.awt.Color(255, 255, 255));
        registerbutton.setText("Register!");
        registerbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(registerbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 100, 34));

        loginbutton.setBackground(new java.awt.Color(102, 102, 102));
        loginbutton.setForeground(new java.awt.Color(255, 255, 255));
        loginbutton.setText("Login!");
        loginbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(loginbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 101, 34));

        cancelreservationbutton.setBackground(new java.awt.Color(255, 102, 102));
        cancelreservationbutton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelreservationbutton.setForeground(new java.awt.Color(255, 255, 255));
        cancelreservationbutton.setText("Cancel Reservation");
        cancelreservationbutton.setMaximumSize(new java.awt.Dimension(114, 23));
        cancelreservationbutton.setMinimumSize(new java.awt.Dimension(114, 23));
        cancelreservationbutton.setPreferredSize(new java.awt.Dimension(114, 23));
        cancelreservationbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelreservationbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelreservationbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 140, -1));

        reservationbutton.setBackground(new java.awt.Color(102, 102, 255));
        reservationbutton.setForeground(new java.awt.Color(255, 255, 255));
        reservationbutton.setText("Reserve a Room");
        reservationbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservationbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(reservationbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 160, -1));

        refreshbutton.setText("Refresh");
        refreshbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(refreshbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 100, 30));

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pendingReservationsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        pendingReservationsTable.setToolTipText("");
        pendingReservationsTable.setGridColor(new java.awt.Color(0, 0, 0));
        pendingReservationsTable.setSelectionBackground(new java.awt.Color(147, 147, 248));
        pendingReservationsTable.getTableHeader().setReorderingAllowed(false);
        pendingReservationsTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pendingReservationsTableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pendingReservationsTableFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(pendingReservationsTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 320, 320));

        SecretButtonAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo background.png"))); // NOI18N
        SecretButtonAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SecretButtonAdminMouseClicked(evt);
            }
        });
        jPanel1.add(SecretButtonAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 100));

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 90, 30));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 19)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("UNIVERSITY");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 210, 40));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 19)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setText("NATIONAL");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 210, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadRoomsIntoTable() {
    Vector<String> columnNames = new Vector<>();
    columnNames.add("Room");
    columnNames.add("Floor");
    columnNames.add("Status");

    Vector<Vector<Object>> data = DatabaseManager.getAllRooms();

    DefaultTableModel model = new DefaultTableModel(data, columnNames) {
        Class[] types = new Class[] { String.class, String.class, String.class };
        boolean[] canEdit = new boolean[] { false, false, false };

        public Class<?> getColumnClass(int columnIndex) {
            return types[columnIndex];
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };

    roomTableModel.setModel(model);
    
    tablestyle.centerTableText(roomTableModel);
    tablestyle.setRoomTableCellRenderer(roomTableModel, 2);
    tablestyle.styleTableHeader(roomTableModel);

}
    
    private String getRoomFloor(String roomName) {
    String floor = "";
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Room_Reservation", "root", "123456789");
         PreparedStatement ps = conn.prepareStatement("SELECT floor FROM rooms WHERE room_name = ?")) {

        ps.setString(1, roomName);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            floor = rs.getString("floor");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return floor;
}
 
    private void loadPendingReservationsForUser(String username) {
    Vector<String> columnNames = new Vector<>();
    columnNames.add("Room");
    columnNames.add("Date");
    columnNames.add("Start Time");
    columnNames.add("End Time");
    columnNames.add("Status");

    Vector<Vector<Object>> data = new Vector<>();

      String query = "SELECT r.room_name, res.date, res.start_time, res.end_time, res.status " +
                   "FROM reservations res " +
                   "JOIN users u ON res.user_id = u.user_id " +
                   "JOIN rooms r ON res.room_id = r.room_id " +
                   "WHERE u.username = ? AND (res.status = 'Pending' OR res.status = 'Approved')";

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Room_Reservation?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "123456789");
         PreparedStatement ps = conn.prepareStatement(query)) {

        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            row.add(rs.getString("room_name"));
            row.add(rs.getDate("date").toString());
            row.add(rs.getString("start_time"));
            row.add(rs.getString("end_time"));
            row.add(rs.getString("status"));
            data.add(row);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Failed to load pending reservations.");
    }

    DefaultTableModel model = new DefaultTableModel(data, columnNames) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    pendingReservationsTable.setModel(model);
}
    private void reservationbuttonActionPerformed(java.awt.event.ActionEvent evt) { 
            if (loggedInUsername == null) {
        JOptionPane.showMessageDialog(this, "Please log in first to make a reservation.");
        return;
    }

    ReservationDetails detailsFrame = new ReservationDetails(loggedInUsername);
    detailsFrame.setLocationRelativeTo(this);
    detailsFrame.setVisible(true);
    }
    private void cancelreservationbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelreservationbuttonActionPerformed

  
    int selectedRow = pendingReservationsTable.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a reservation to cancel.");
        return;
    }

    String roomName = pendingReservationsTable.getValueAt(selectedRow, 0).toString();
    String date = pendingReservationsTable.getValueAt(selectedRow, 1).toString();
    String startTime = pendingReservationsTable.getValueAt(selectedRow, 2).toString();
    String endTime = pendingReservationsTable.getValueAt(selectedRow, 3).toString();

    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel this reservation?", "Confirm", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Room_Reservation?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "123456789")) {
        String deleteQuery = "DELETE FROM reservations " +
                             "WHERE user_id = (SELECT user_id FROM users WHERE username = ?) " +
                             "AND room_id = (SELECT room_id FROM rooms WHERE room_name = ?) " +
                             "AND date = ? AND start_time = ? AND end_time = ? " +
                             "AND status IN ('Pending', 'Approved')";

        try (PreparedStatement ps = conn.prepareStatement(deleteQuery)) {
            ps.setString(1, loggedInUsername);
            ps.setString(2, roomName);
            ps.setString(3, date);
            ps.setString(4, startTime);
            ps.setString(5, endTime);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                // 🟢 Update room status after successful cancellation
                boolean updated = DatabaseManager.updateRoomStatus(roomName, getRoomFloor(roomName), "Available");

                if (updated) {
                    JOptionPane.showMessageDialog(this, "Reservation cancelled and room marked as available.");
                } else {
                    JOptionPane.showMessageDialog(this, "Reservation cancelled, but failed to update room status.");
                }

                loadPendingReservationsForUser(loggedInUsername);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to cancel reservation. Please try again.");
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Database error while cancelling reservation.");
    }
    }//GEN-LAST:event_cancelreservationbuttonActionPerformed

    private void roomTableModelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roomTableModelFocusGained
   
    }//GEN-LAST:event_roomTableModelFocusGained

    private void roomTableModelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roomTableModelFocusLost
       
    }//GEN-LAST:event_roomTableModelFocusLost

    private void SecretButtonAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SecretButtonAdminMouseClicked

            adminpanel adminPanel = new adminpanel();
    adminPanel.setVisible(true);
    adminPanel.setLocationRelativeTo(this);
    
    }//GEN-LAST:event_SecretButtonAdminMouseClicked

    private void registerbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbuttonActionPerformed
      String username = JOptionPane.showInputDialog(this, "Enter username:");

    // Create the password field for password input
    JPasswordField passwordField = new JPasswordField(20);
    JPanel panel = new JPanel();
    panel.add(new JLabel("Enter password:"));
    panel.add(passwordField);

    // Show the panel with password field in JOptionPane
    int option = JOptionPane.showConfirmDialog(this, panel, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    String password = new String(passwordField.getPassword()); // Convert char[] to String

    if (username != null && password != null && !username.isEmpty() && !password.isEmpty() && option == JOptionPane.OK_OPTION) {
        boolean success = DatabaseManager.registerUser(username, password);
        JOptionPane.showMessageDialog(this,
            success ? "Registration successful!" : "Registration failed. Try another username.");
    } else {
        JOptionPane.showMessageDialog(this, "Username and password cannot be empty.");
    }
    }//GEN-LAST:event_registerbuttonActionPerformed

    private void loginbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbuttonActionPerformed
     String username = JOptionPane.showInputDialog(this, "Username:");
     
    // Create the password field for password input
    JPasswordField passwordField = new JPasswordField(20);
    JPanel panel = new JPanel();
    panel.add(new JLabel("Password:"));
    panel.add(passwordField);

    // Show the panel with password field in JOptionPane
    int option = JOptionPane.showConfirmDialog(this, panel, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    String password = new String(passwordField.getPassword()); // Convert char[] to String

    if (option == JOptionPane.OK_OPTION && DatabaseManager.authenticateUser(username, password)) {
        loggedInUsername = username;
        JOptionPane.showMessageDialog(this, "Login successful!");
        jLabel4.setText(username);
        registerbutton.setVisible(false);
        loginbutton.setVisible(false);
        loadPendingReservationsForUser(username);
        tablestyle.centerTableText(pendingReservationsTable);
        tablestyle.setRoomTableCellRenderer(pendingReservationsTable, 4);
        tablestyle.styleTableHeader(pendingReservationsTable);
         refreshbutton.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Login failed. Invalid credentials.");
    }

   
    }//GEN-LAST:event_loginbuttonActionPerformed

    private void pendingReservationsTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pendingReservationsTableFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_pendingReservationsTableFocusGained

    private void pendingReservationsTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pendingReservationsTableFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_pendingReservationsTableFocusLost

    private void refreshbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshbuttonActionPerformed
     loadRoomsIntoTable();
    if (loggedInUsername != null) {
        loadPendingReservationsForUser(loggedInUsername);
        tablestyle.centerTableText(pendingReservationsTable);
        tablestyle.setRoomTableCellRenderer(pendingReservationsTable, 4);
        tablestyle.styleTableHeader(pendingReservationsTable);
    }
    }//GEN-LAST:event_refreshbuttonActionPerformed

 
 
    public static void main(String args[]) {
 try {
        javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
    } catch (Exception ex) {
        System.err.println("Failed to initialize LaF");
    }

    List<Reservation> reservations = new ArrayList<>();
    
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            Main mainGui = new Main();
            mainGui.setLocationRelativeTo(null); // center window on screen
            mainGui.setVisible(true); 
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SecretButtonAdmin;
    private javax.swing.JButton cancelreservationbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton loginbutton;
    private javax.swing.JTable pendingReservationsTable;
    private javax.swing.JButton refreshbutton;
    private javax.swing.JButton registerbutton;
    private javax.swing.JButton reservationbutton;
    private javax.swing.JTable roomTableModel;
    // End of variables declaration//GEN-END:variables
}