package test.blackbox;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import snippet.Showtime;

class TestShowShowtimes {

	@Test
    public void testShowShowtimes_NoShowtimes() {
        // Arrange
        Showtime showtimeManager = new Showtime();

        // Redirect console output to verify
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        showtimeManager.showShowtimes();

        // Assert
        String output = out.toString().trim();
        assertEquals("No showtimes available.", output);
    }

    @Test
    public void testShowShowtimeDetails_ValidShowtime() {
        // Arrange
        Showtime showtimeManager = new Showtime();
        showtimeManager.insertShowtime(1, 101, LocalDateTime.of(2025, 1, 15, 18, 30));

        // Redirect console output to verify
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        showtimeManager.showShowtimeDetails(1);

        // Assert
        String output = out.toString().trim();
        assertTrue(output.contains("Showtime ID: 1"));
    }


}
