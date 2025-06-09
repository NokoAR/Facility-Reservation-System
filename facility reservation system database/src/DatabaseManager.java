import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Room_Reservation?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123456789";

    // Establishes a connection to the database
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

      public static Vector<Vector<Object>> getAllRooms() {
        Vector<Vector<Object>> roomsData = new Vector<>();

        String sql = "SELECT room_name, floor, status FROM rooms ORDER BY floor, room_name";

        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("room_name"));
                row.add(rs.getString("floor"));
                row.add(rs.getString("status"));
                roomsData.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roomsData;
    }
    public static List<Reservation> getAllReservations() {
        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT r.id, u.username, rm.floor, rm.room_name AS room, r.purpose, r.date, r.start_time, r.end_time, r.status "
           + "FROM reservations r "
           + "JOIN users u ON r.user_id = u.user_id "
           + "JOIN rooms rm ON r.room_id = rm.room_id";

        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                    Reservation r = new Reservation(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("purpose"),
                    rs.getDate("date"),
                    rs.getString("start_time"),
                    rs.getString("end_time"),
                    rs.getString("floor"),      // from rooms table
                    rs.getString("room"),       // alias for room_name
                    rs.getString("status")
                );
                list.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Registers a new user
    public static boolean registerUser(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error registering user: " + e.getMessage());
            return false;
        }
    }
    public static boolean authenticateUser(String username, String password) {
    String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
    try (Connection conn = connect();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, username);
        ps.setString(2, password);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next() && rs.getInt(1) > 0)
                return true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
    // Retrieves reservations for a single user
    public static List<Reservation> getReservationsByUser(String username) {
        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT r.id, u.username, r.floor, r.room, r.purpose, r.date, r.start_time, r.end_time, r.status"
                   + " FROM reservations r"
                   + " JOIN users u ON r.user_id = u.user_id"
                   + " WHERE u.username = ?";

        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Reservation r = new Reservation(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("purpose"),
                    rs.getDate("date"),
                    rs.getString("start_time"),
                    rs.getString("end_time"),
                    rs.getString("floor"),      // from rooms table
                    rs.getString("room"),       // alias for room_name
                    rs.getString("status")
                );
                    list.add(r);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static boolean insertReservation(Reservation r) {
  String sql = "INSERT INTO reservations "
             + "(user_id, room, floor, purpose, date, start_time, end_time, status) "
             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
  try (Connection conn = connect();
       PreparedStatement ps = conn.prepareStatement(sql)) {
    ps.setInt(1, r.getId());
    ps.setString(2, r.getRoom());
    ps.setString(3, r.getFloor());
    ps.setString(4, r.getPurpose());
    ps.setDate(5, new java.sql.Date(r.getDate().getTime()));
    ps.setTime(6, java.sql.Time.valueOf(r.getStartTime() + ":00"));
    ps.setTime(7, java.sql.Time.valueOf(r.getEndTime()   + ":00"));
    ps.setString(8, r.getStatus());
    ps.executeUpdate();
    return true;
  } catch (SQLException e) {
    e.printStackTrace();
    return false;
  }
}
    public static boolean approveReservation(int reservationId) {
    String sql = "UPDATE reservations SET status = 'Approved' WHERE id = ?";

    try (Connection conn = connect();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, reservationId);
        int rowsUpdated = ps.executeUpdate();

        return rowsUpdated > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    public static boolean updateRoomStatus(String room, String floor, String status) {
    String sql = "UPDATE rooms SET status = ? WHERE room_name = ? AND floor = ?";
    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, status);
        pstmt.setString(2, room);
        pstmt.setString(3, floor);
        return pstmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    // Deletes a reservation by its ID
    public static boolean deleteReservation(int reservationId) {
        String sql = "DELETE FROM reservations WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, reservationId);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
