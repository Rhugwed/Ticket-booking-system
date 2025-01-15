package test.blackbox;


import org.junit.Test;
import snippet.Showtime;

import java.time.LocalDateTime;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ShowtimeBlackBoxTest {

    @Test
    public void testRemoveShowtime_ValidID() {
        // Arrange
        Showtime showtimeManager = new Showtime();
        showtimeManager.insertShowtime(1, 101, LocalDateTime.now());

        // Redirect console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        showtimeManager.removeShowtime(1);

        // Assert
        String actualOutput = out.toString().trim();
        assertTrue(actualOutput.contains("Showtime with ID 1 removed successfully."));
        assertEquals(0, showtimeManager.getShowtimeCount());
    }

    @Test
    public void testRemoveShowtime_InvalidID() {
        // Arrange
        Showtime showtimeManager = new Showtime();
        showtimeManager.insertShowtime(1, 101, LocalDateTime.now());

        // Redirect console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        showtimeManager.removeShowtime(99);

        // Assert
        String actualOutput = out.toString().trim();
        assertTrue(actualOutput.contains("No showtime found with ID: 99"));
        assertEquals(1, showtimeManager.getShowtimeCount());
    }

    @Test
    public void testRemoveShowtime_NegativeID() {
        // Arrange
        Showtime showtimeManager = new Showtime();
        showtimeManager.insertShowtime(1, 101, LocalDateTime.now());

        // Redirect console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        try {
            showtimeManager.removeShowtime(-1);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            // Assert
            assertEquals("Invalid showtime ID.", e.getMessage());
        }
    }
}
