package test.whitebox;

import org.junit.Test;
import snippet.Booking;
import snippet.Showtime;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class BookingTest {

    @Test
    public void testBookTicketIntegration_ValidInput() {
        // Arrange: Real Showtime instance
        Showtime showtimeManager = new Showtime();
        Booking bookingManager = new Booking(showtimeManager);

        // Add a valid showtime
        showtimeManager.insertShowtime(1, 101, LocalDateTime.now());

        // Act: Book a valid seat
        String result = bookingManager.bookTicketWithFeedback(1, 1, 10);

        // Assert: Verify booking success
        assertEquals("Booking confirmed. Showtime ID: 1, Seat: 10", result);
    }

    @Test
    public void testBookTicketIntegration_InvalidShowtime() {
        // Arrange: Real Showtime instance
        Showtime showtimeManager = new Showtime();
        Booking bookingManager = new Booking(showtimeManager);

        // invalid showtime ID
        String result = bookingManager.bookTicketWithFeedback(1, 99, 10);

        // Assert: Verify error message
        assertEquals("Error: Invalid showtime ID.", result);
    }

    @Test
    public void testBookTicketIntegration_SeatAlreadyBooked() {
        // Real Showtime instance
        Showtime showtimeManager = new Showtime();
        Booking bookingManager = new Booking(showtimeManager);

        // Add a valid showtime
        showtimeManager.insertShowtime(1, 101, LocalDateTime.now());

        // Book a valid seat
        bookingManager.bookTicketWithFeedback(1, 1, 10);

        // Atrampt to book the same
        String result = bookingManager.bookTicketWithFeedback(2, 1, 10);

        //  Verify error message
        assertEquals("Error: Seat is already booked.", result);
    }
}
