package test.blackbox;

import org.junit.Test;
import snippet.User;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class CancelTicketBlackBoxTest {

    @Test
    public void testCancelTicket_NoBookings() {
        User user = new User("Jane Doe", "janedoe", "password123", "456 Avenue", "9876543210");

        // Redirect console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act: Attempt to cancel when there are no bookings
        user.cancelTicketBooking(1);

        // Assert: Verify the error message
        assertTrue(out.toString().contains("No bookings found for this user."));
    }

}