import java.util.Date;

public class Reservation {
    private int id;
    private String user;
    private String purpose;
    private Date date;
    private String startTime;
    private String endTime;
    private String floor;
    private String room;
    private String status;

    // Full constructor including database ID
    public Reservation(int id,
                       String user,
                       String purpose,
                       Date date,
                       String startTime,
                       String endTime,
                       String floor,
                       String room,
                       String status) {
        this.id = id;
        this.user = user;
        this.purpose = purpose;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.floor = floor;
        this.room = room;
        this.status = status;
    }

    // Constructor without ID for new reservations
    public Reservation(String user,
                       String purpose,
                       Date date,
                       String startTime,
                       String endTime,
                       String floor,
                       String room,
                       String status) {
        this(0, user, purpose, date, startTime, endTime, floor, room, status);
    }

    // Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUser() {
        return user;
    }
    public String getPurpose() {
        return purpose;
    }
    public Date getDate() {
        return date;
    }
    public String getStartTime() {
        return startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public String getFloor() {
        return floor;
    }
    public String getRoom() {
        return room;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
