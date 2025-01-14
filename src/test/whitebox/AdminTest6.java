package test.whitebox;

import org.junit.Test;
import snippet.Admin;
import snippet.Showtime;

import java.time.LocalDateTime;

public class AdminTest6 {

    @Test
    public void testRemoveExpiredShowtimes_WithExpired() {

        Showtime showtimeManager = new Showtime();
        Admin admin = new Admin(null, null, showtimeManager);


        showtimeManager.insertShowtime(1, 101, LocalDateTime.of(2025, 1, 10, 18, 30)); 
        showtimeManager.insertShowtime(2, 102, LocalDateTime.of(2025, 1, 15, 18, 30)); 


        System.out.println("--- Test: Remove Expired Showtimes ---");
        admin.removeExpiredShowtimes(); 
    }

    @Test
    public void testRemoveExpiredShowtimes_NoExpired() {

        Showtime showtimeManager = new Showtime();
        Admin admin = new Admin(null, null, showtimeManager);


        showtimeManager.insertShowtime(1, 101, LocalDateTime.of(2025, 1, 15, 18, 30));
        showtimeManager.insertShowtime(2, 102, LocalDateTime.of(2025, 1, 16, 18, 30));


        System.out.println("--- Test: Remove Expired Showtimes (No Expired) ---");
        admin.removeExpiredShowtimes(); 
    }

    @Test
    public void testRemoveExpiredShowtimes_NoShowtimes() {
        
        Showtime showtimeManager = new Showtime();
        Admin admin = new Admin(null, null, showtimeManager);


        System.out.println("--- Test: Remove Expired Showtimes (No Showtimes) ---");
        admin.removeExpiredShowtimes();
    }
}