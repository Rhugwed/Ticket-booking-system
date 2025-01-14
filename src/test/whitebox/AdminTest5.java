package test.whitebox;

import org.junit.Test;
import snippet.Admin;
import snippet.Showtime;

import java.time.LocalDateTime;

public class AdminTest5 {

    @Test
    public void testViewShowtimeDetails_ValidID() {
        Showtime showtimeManager = new Showtime();
        Admin admin = new Admin(null, null, showtimeManager);

        showtimeManager.insertShowtime(1, 101, LocalDateTime.of(2025, 1, 15, 18, 30));


        System.out.println("--- Test: View Showtime Details (Valid ID) ---");
        System.setIn(new java.io.ByteArrayInputStream("1\n".getBytes())); 
        admin.viewShowtimes(); 
    }

    @Test
    public void testViewShowtimeDetails_InvalidID() {
        
        Showtime showtimeManager = new Showtime();
        Admin admin = new Admin(null, null, showtimeManager);

        
        showtimeManager.insertShowtime(1, 101, LocalDateTime.of(2025, 1, 15, 18, 30));

        
        System.out.println("--- Test: View Showtime Details (Invalid ID) ---");
        System.setIn(new java.io.ByteArrayInputStream("2\n".getBytes())); 
        admin.viewShowtimes(); 
    }

    @Test
    public void testViewShowtimeDetails_NoShowtimes() {
       
        Showtime showtimeManager = new Showtime();
        Admin admin = new Admin(null, null, showtimeManager);

       
        System.out.println("--- Test: View Showtime Details (No Showtimes) ---");
        System.setIn(new java.io.ByteArrayInputStream("1\n".getBytes())); 
        admin.viewShowtimes(); 
    }
}