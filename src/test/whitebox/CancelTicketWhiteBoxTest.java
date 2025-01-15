package test.whitebox;

import org.junit.Test;
import snippet.User;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CancelTicketWhiteBoxTest {

    @Test
    public void testCancelTicketBooking_NoBookings() {
        User user = new User("John Doe", "johndoe", "password123", "123 Street", "1234567890");

        // Redirect console output to verify behavior
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act: Attempt to cancel a ticket when there are no bookings
        user.cancelTicketBooking(1);

        // Assert: Verify the appropriate message is displayed
        assertTrue(out.toString().contains("No bookings found for this user."));
    }
    
}