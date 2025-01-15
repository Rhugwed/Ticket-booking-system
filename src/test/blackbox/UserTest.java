package test.blackbox;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import snippet.Booking;
import snippet.Showtime;
import snippet.User;

class UserTest {

	@Test
    public void testViewTicketBookings_NoBookings() {
        // Arrange
        Showtime showtimeManager = new Showtime();
        Booking bookingManager = new Booking(showtimeManager);
        User user = new User("Alice", "alice123", "password", "123 Lane", "9876543210");

        // Redirect console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        user.viewTicketBookings(1);

        // Capture the actual output
        String actualOutput = out.toString().trim();
        assertTrue(actualOutput.contains("No bookings found for this user."));
    }

    @Test
    public void testCancelTicket_NoBookings() {
        // Arrange
        Showtime showtimeManager = new Showtime();
        Booking bookingManager = new Booking(showtimeManager);
        User user = new User("Alice", "alice123", "password", "123 Lane", "9876543210");

        // Redirect console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        user.cancelTicketBooking(1);

        // Capture the actual output
        String actualOutput = out.toString().trim();
        assertTrue(actualOutput.contains("No bookings found for this user."));
    }

}
