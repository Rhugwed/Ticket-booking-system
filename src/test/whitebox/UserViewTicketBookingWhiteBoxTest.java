package test.whitebox;

import org.junit.Test;
import snippet.Showtime;
import snippet.Booking;
import snippet.User;

public class UserViewTicketBookingWhiteBoxTest {

    @Test
    public void testViewTicketBookings_CallsSeeTicket() {
        // Create the dependencies
        Showtime showtimeManager = new Showtime();
        Booking bookingManager = new Booking(showtimeManager);
        User user = new User("Charlie", "charlie123", "password", "789 Boulevard", "9876543210");

        // Add a showtime and a booking
        showtimeManager.insertShowtime(1, 1, java.time.LocalDateTime.now()); // Add Showtime
        bookingManager.bookTicketWithFeedback(1, 1, 10); // User 1 books seat 10

        // Test case where seeTicket is called
        System.out.println("--- Test: Validate Method Logic ---");
        user.viewTicketBookings(1); // User ID = 1
        // Expected Output: Booking details for user.
    }

    @Test
    public void testViewTicketBookings_InvalidUserID() {
        // Create the dependencies
        Showtime showtimeManager = new Showtime();
        Booking bookingManager = new Booking(showtimeManager);
        User user = new User("Dave", "dave123", "password", "101 Main St", "1231231234");

        // Test case where invalid userID is passed
        System.out.println("--- Test: Invalid UserID ---");
        user.viewTicketBookings(-1); // Invalid User ID
        // Expected Output: "No bookings found for this user."
    }
}
