package test.whitebox;

import org.junit.Test;
import snippet.Booking;
import snippet.Showtime;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class BookingWhiteBoxTest2 {

    @Test
    public void testViewAvailableShowtimes_WithShowtimes() {
        // Arrange
        Showtime showtimeManager = new Showtime();
        Booking bookingManager = new Booking(showtimeManager);

        // Add showtimes
        showtimeManager.insertShowtime(1, 101, LocalDateTime.now());
        showtimeManager.insertShowtime(2, 102, LocalDateTime.now().plusHours(2));

        // Redirect console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        bookingManager.viewAvailableShowtimes();

        // Assert
        String actualOutput = out.toString().trim();
        assertTrue(actualOutput.contains("Showtime ID: 1"));
        assertTrue(actualOutput.contains("Showtime ID: 2"));
    }

    @Test
    public void testViewAvailableShowtimes_NoShowtimes() {
        // Arrange
        Showtime showtimeManager = new Showtime();
        Booking bookingManager = new Booking(showtimeManager);

        // Redirect console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        bookingManager.viewAvailableShowtimes();

        // Assert
        String actualOutput = out.toString().trim();
        assertEquals("--- Available Showtimes ---\nNo showtimes available.", actualOutput);
    }
}
