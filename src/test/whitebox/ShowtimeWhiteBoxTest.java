package test.whitebox;

import org.junit.Test;
import snippet.Showtime;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class ShowtimeWhiteBoxTest {

    @Test
    public void testRemoveShowtime_ValidID() {
        // Arrange
        Showtime showtimeManager = new Showtime();
        showtimeManager.insertShowtime(1, 101, LocalDateTime.now());

        // Act
        showtimeManager.removeShowtime(1);

        // Assert
        assertEquals(0, showtimeManager.getShowtimeCount());
    }

    @Test
    public void testRemoveShowtime_InvalidID() {
        // Arrange
        Showtime showtimeManager = new Showtime();
        showtimeManager.insertShowtime(1, 101, LocalDateTime.now());

        // Act
        showtimeManager.removeShowtime(99); // Invalid ID

        // Assert
        assertEquals(1, showtimeManager.getShowtimeCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShowtime_NegativeID() {
        // Arrange
        Showtime showtimeManager = new Showtime();
        showtimeManager.insertShowtime(1, 101, LocalDateTime.now());

        // Act
        showtimeManager.removeShowtime(-1); // Negative ID
    }
}