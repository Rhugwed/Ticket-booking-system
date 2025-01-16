package test.whitebox;
import org.junit.Test;
import snippet.Booking;
import snippet.Showtime;

import java.time.LocalDateTime;


public class ViewTest {

    @Test
    public void testSeeTicket_NoBookings() {
        // Arrange
        Showtime showtimeManager = new Showtime();
        Booking bookingManager = new Booking(showtimeManager);

        // Act & Assert
        System.out.println("--- Test: No Bookings ---");
        bookingManager.seeTicket(1);
    }

    
    public void testSeeTicket_WithBookings() {
        // Arrange
        Showtime showtimeManager = new Showtime();
        Booking bookingManager = new Booking(showtimeManager);

        showtimeManager.insertShowtime(1, 101, LocalDateTime.now());
        bookingManager.bookTicketWithFeedback(1, 1, 5);
        bookingManager.bookTicketWithFeedback(1, 1, 10);

        // Act
        System.out.println("--- Test: View Bookings ---");
        bookingManager.seeTicket(1);
    }

   
}
