package snippet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Booking {

    // Dependencies
    private Showtime showtimeManager = new Showtime();
    private List<BookingRecord> bookings = new ArrayList<>(); // In-memory storage for bookings
    private Scanner sc = new Scanner(System.in);

    // Inner class to represent a booking record
    private static class BookingRecord {
        int userID;
        int showtimeID;
        int seatNumber;

        public BookingRecord(int userID, int showtimeID, int seatNumber) {
            this.userID = userID;
            this.showtimeID = showtimeID;
            this.seatNumber = seatNumber;
        }
    }

    // Book a ticket
    public void bookTicket(int userID) {
        System.out.println("Available showtimes:");
        showtimeManager.showShowtimes();

        System.out.print("Enter your showtime choice (Showtime ID): ");
        int showtimeChoice = sc.nextInt();

        // Fetch the theater's seating capacity for the selected showtime
        int capacity = showtimeManager.getTheatreCapacity(showtimeChoice);

        // Find already booked seats for this showtime
        List<Integer> bookedSeats = getBookedSeats(showtimeChoice);

        // Display seat availability
        System.out.println("---------- Available Seats ----------");
        for (int i = 1; i <= capacity; i++) {
            if (bookedSeats.contains(i)) {
                System.out.print("X ");
            } else {
                System.out.print(i + " ");
            }

            if (i % 8 == 0) {
                System.out.println(); // New line after every 8 seats
            }
        }

        // User selects a seat
        System.out.print("\nEnter the seat number of your choice: ");
        int seatChoice = sc.nextInt();

        if (bookedSeats.contains(seatChoice)) {
            System.out.println("Seat is already booked. Please choose a different seat.");
            return;
        }

        // Add the booking record
        bookings.add(new BookingRecord(userID, showtimeChoice, seatChoice));
        System.out.println("Booking completed successfully!");
    }

    // View tickets booked by a user
    public void seeTicket(int userID) {
        System.out.println("Your Bookings:");
        boolean hasBookings = false;

        // Display bookings for the user
        for (BookingRecord booking : bookings) {
            if (booking.userID == userID) {
                hasBookings = true;
                System.out.println("Showtime ID: " + booking.showtimeID + ", Seat Number: " + booking.seatNumber);
            }
        }

        if (!hasBookings) {
            System.out.println("No bookings found for this user.");
            return;
        }

        // Show details for a specific showtime
        System.out.print("Enter Showtime ID to view details: ");
        int showtimeIDChoice = sc.nextInt();
        showtimeManager.showShowtimeDetails(showtimeIDChoice);
    }

    // Cancel a ticket
    public void cancelTicket(int userID) {
        System.out.println("Your Bookings:");
        boolean hasBookings = false;

        // Display bookings for the user
        for (BookingRecord booking : bookings) {
            if (booking.userID == userID) {
                hasBookings = true;
                System.out.println("Booking ID: " + bookings.indexOf(booking) + ", Showtime ID: " + booking.showtimeID + ", Seat Number: " + booking.seatNumber);
            }
        }

        if (!hasBookings) {
            System.out.println("No bookings found for this user.");
            return;
        }

        // User selects a booking to cancel
        System.out.print("Enter Booking ID to cancel: ");
        int bookingID = sc.nextInt();

        if (bookingID >= 0 && bookingID < bookings.size() && bookings.get(bookingID).userID == userID) {
            bookings.remove(bookingID);
            System.out.println("Booking canceled successfully.");
        } else {
            System.out.println("Invalid Booking ID. Cancellation failed.");
        }
    }

    // Helper method: Get booked seats for a specific showtime
    private List<Integer> getBookedSeats(int showtimeID) {
        List<Integer> bookedSeats = new ArrayList<>();
        for (BookingRecord booking : bookings) {
            if (booking.showtimeID == showtimeID) {
                bookedSeats.add(booking.seatNumber);
            }
        }
        return bookedSeats;
    }

	public void viewAvailableShowtimes() {
		// TODO Auto-generated method stub
		
	}
}
