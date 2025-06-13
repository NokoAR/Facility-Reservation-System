Download the "Mysql-installer-web-community-8.0.42.0.msi" inside the drive.
 
 ![image alt](https://github.com/NokoAR/Facility-Reservation-System/blob/569b12874e127fcedc17d50206c26225e7460665/Images%20Tutorial/Mysql%20DL.PNG)

Install it in the folder.

Select server > then server only. Select MYsql > execute. Press Next after. Next again

![image alt](https://github.com/NokoAR/Facility-Reservation-System/blob/fc28cadf6e79ce0ec6af8e989b6fcde3cbd6fffe/Images%20Tutorial/3.PNG)

![image alt](https://github.com/NokoAR/Facility-Reservation-System/blob/ce7b6b63ff548689adb7e1c143270b167c368a77/Images%20Tutorial/3-1.PNG)

Everything is default. DONT TOUCH. press next

![image alt](https://github.com/NokoAR/Facility-Reservation-System/blob/ce7b6b63ff548689adb7e1c143270b167c368a77/Images%20Tutorial/4.PNG)

![image alt](https://github.com/NokoAR/Facility-Reservation-System/blob/ce7b6b63ff548689adb7e1c143270b167c368a77/Images%20Tutorial/4-1.PNG)

Set the password to 123456789, Password must be the same, then next

![image alt](https://github.com/NokoAR/Facility-Reservation-System/blob/ce7b6b63ff548689adb7e1c143270b167c368a77/Images%20Tutorial/5.PNG)

Next again, next, Execute, FINISH.

![image alt](https://github.com/NokoAR/Facility-Reservation-System/blob/ce7b6b63ff548689adb7e1c143270b167c368a77/Images%20Tutorial/6.PNG)

![image alt](https://github.com/NokoAR/Facility-Reservation-System/blob/ce7b6b63ff548689adb7e1c143270b167c368a77/Images%20Tutorial/6-1.PNG)

![image alt](https://github.com/NokoAR/Facility-Reservation-System/blob/ce7b6b63ff548689adb7e1c143270b167c368a77/Images%20Tutorial/6-2.PNG)

Open apache netbeans and the facility reservation system

Select the project on the project window, select Window > Services.

![image alt](https://github.com/NokoAR/Facility-Reservation-System/blob/71b4cb56a6c5e4a125bbeb678edaaa348bfced91/Images%20Tutorial/Windows.PNG)

![image alt](https://github.com/NokoAR/Facility-Reservation-System/blob/ce7b6b63ff548689adb7e1c143270b167c368a77/Images%20Tutorial/8.PNG)

Select the dropdown of Databases > Drivers, right click "MySQL(Connector/J driver)" then find the jar file mysql connector, inside the facility reservation system > lib".

Input the password, Next, Next(No Schema), Then name the connection name to "Facility Reservation System".

![image alt](https://github.com/NokoAR/Facility-Reservation-System/blob/ce7b6b63ff548689adb7e1c143270b167c368a77/Images%20Tutorial/10.PNG)

![image alt](https://github.com/NokoAR/Facility-Reservation-System/blob/ce7b6b63ff548689adb7e1c143270b167c368a77/Images%20Tutorial/10-1.PNG)

right click "Facility Reservation System" then "connect", right click again > "Execute Command".

CODING PART: write this in the SQL 1 window: "CREATE DATABASE Room_Reservation", then Run.

![image alt](https://github.com/NokoAR/Facility-Reservation-System/blob/ce7b6b63ff548689adb7e1c143270b167c368a77/Images%20Tutorial/12.PNG)

This should show up

![image alt](https://github.com/NokoAR/Facility-Reservation-System/blob/ce7b6b63ff548689adb7e1c143270b167c368a77/Images%20Tutorial/13.PNG)

Erase the code on line 1, Type in this: 

CREATE TABLE Room_Reservation.users (
user_id INTEGER PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(32) NOT NULL,
password VARCHAR(32) NOT NULL
)

Just like before, Press run, No error should show up

Remove the code, type in: 

CREATE TABLE Room_Reservation.rooms (
    room_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    room_name VARCHAR(50) NOT NULL UNIQUE,
    floor VARCHAR(50) NOT NULL,
    status VARCHAR(50) DEFAULT 'Available' 
);

Run.

Remove the code, type in: 

CREATE TABLE Room_Reservation.reservations (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    user_id INTEGER ,
    room_id INTEGER NOT NULL,
    purpose TEXT,
    date TEXT,
    start_time TEXT,
    end_time TEXT,
    status TEXT,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (room_id) REFERENCES rooms(room_id)

);

On the Services window, Dropdown the Facility Reservation System > Other Database, right click "room_reservation", select "Set as Default Catalog"

![image alt](https://github.com/NokoAR/Facility-Reservation-System/blob/ce7b6b63ff548689adb7e1c143270b167c368a77/Images%20Tutorial/19.PNG)

Lastly, remove the code, type in: 

INSERT INTO rooms (room_name, floor) VALUES
('Prayer Room', '4F'),
('401', '4F'),
('402', '4F'),
('403', '4F'),
('404', '4F'),
('405', '4F'),
('Gynasium', '5F'),
('Table Tennis Room', '5F'),
('Discussion room', '5F'),
('501', '5F'),
('502', '5F'),
('503', '5F'),
('504', '5F'),
('505', '5F');

Run.

Open Main then run the Program

![image alt](https://github.com/NokoAR/Facility-Reservation-System/blob/6e6ef09de4b4ea1109fed71dd3adc9deed784a23/Images%20Tutorial/MAIN.PNG)
