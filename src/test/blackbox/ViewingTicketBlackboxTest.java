package test.blackbox;

import org.junit.Test;
import snippet.Booking;
import snippet.Showtime;

import java.time.LocalDateTime;
import java.io.ByteArrayInputStream;

public class ViewingTicketBlackboxTest {

    @Test
    public void testSeeTicket_EmptyBookings() {
        // Arrange
        Showtime showtimeManager = new Showtime();
        Booking bookingManager = new Booking(showtimeManager);

        // Act
        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);

        System.out.println("--- Test: No Bookings ---");
        bookingManager.seeTicket(1);
    }

    @Test
    public void testSeeTicket_ViewSpecificShowtime() {
        // Arrange
        Showtime showtimeManager = new Showtime();
        Booking bookingManager = new Booking(showtimeManager);

        showtimeManager.insertShowtime(1, 101, LocalDateTime.now());
        bookingManager.bookTicketWithFeedback(1, 1, 5);

        // Act
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n".getBytes());
        System.setIn(in);

        System.out.println("--- Test: View Specific Showtime ---");
        bookingManager.seeTicket(1);
    }

    
}