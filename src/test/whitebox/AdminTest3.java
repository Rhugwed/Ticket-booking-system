package test.whitebox;

import org.junit.Test;
import snippet.Admin;
import snippet.Showtime;

import java.time.LocalDateTime;

public class AdminTest3 {
    @Test
    public void testViewShowtimes() {
        Showtime showtimeManager = new Showtime();
        Admin admin = new Admin(null, null, showtimeManager);

        // Add showtimes
        showtimeManager.insertShowtime(1, 1, LocalDateTime.of(2025, 1, 15, 18, 30));
        showtimeManager.insertShowtime(2, 1, LocalDateTime.of(2025, 1, 15, 20, 0));

        // View showtimes
        System.out.println("--- Test: View Showtimes ---");
        admin.viewShowtimes();
    }

    @Test
    public void testViewShowtimes_NoShowtimes() {
        Showtime showtimeManager = new Showtime();
        Admin admin = new Admin(null, null, showtimeManager);

        // View showtimes with no data
        System.out.println("--- Test: View Showtimes (Empty) ---");
        admin.viewShowtimes();
    }
}