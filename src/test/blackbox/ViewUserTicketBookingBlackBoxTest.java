package test.blackbox;

import org.junit.Test;
import snippet.Showtime;
import snippet.Booking;
import snippet.User;

import static org.junit.Assert.assertEquals;

public class ViewUserTicketBookingBlackBoxTest {

    @Test
    public void testViewTicketBookings_NoBookings() {
        // Create the dependencies
        Showtime showtimeManager = new Showtime();
        Booking bookingManager = new Booking(showtimeManager);
        User user = new User("Alice", "alice123", "password", "123 Street", "1234567890");

        // Test case where no bookings exist
        System.out.println("--- Test: No Bookings for User ---");
        user.viewTicketBookings(1); // User ID = 1
        // Expect output: "No bookings found for this user."
    }

    @Test
    public void testViewTicketBookings_WithBookings() {
        // Create the dependencies
        Showtime showtimeManager = new Showtime();
        Booking bookingManager = new Booking(showtimeManager);
        User user = new User("Bob", "bob123", "password", "456 Avenue", "9876543210");

        // Add a showtime and a booking
        showtimeManager.insertShowtime(1, 1, java.time.LocalDateTime.now());
        String bookingResponse = bookingManager.bookTicketWithFeedback(1, 1, 5); // User 1 books seat 5
        assertEquals("Booking confirmed. Showtime ID: 1, Seat: 5", bookingResponse);

        // Test case where bookings exist
        System.out.println("--- Test: Bookings Exist for User ---");
        user.viewTicketBookings(1); // User ID = 1
        // Expect output: Booking details for user (e.g., "Showtime ID: 1, Seat Number: 5").
    }
}
