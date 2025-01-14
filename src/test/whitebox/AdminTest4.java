package test.whitebox;

import org.junit.Test;
import snippet.Admin;
import snippet.Showtime;

import java.time.LocalDateTime;

public class AdminTest4 {

    @Test
    public void testCountShowtimes_WithShowtimes() {
        // Arrange
        Showtime showtimeManager = new Showtime();
        Admin admin = new Admin(null, null, showtimeManager);

        // Add sample showtimes
        showtimeManager.insertShowtime(1, 1, LocalDateTime.of(2025, 1, 15, 18, 30));
        showtimeManager.insertShowtime(2, 1, LocalDateTime.of(2025, 1, 16, 20, 0));

        // Act
        System.out.println("--- Test: Count Total Showtimes ---");
        admin.countShowtimes(); // Should display "Total number of showtimes: 2"
    }

    @Test
    public void testCountShowtimes_NoShowtimes() {
        // Arrange
        Showtime showtimeManager = new Showtime();
        Admin admin = new Admin(null, null, showtimeManager);

        // Act
        System.out.println("--- Test: Count Total Showtimes (No Showtimes) ---");
        admin.countShowtimes(); // Should display "No showtimes available."
    }
}