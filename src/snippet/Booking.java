package snippet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Booking {

    // Dependencies
    private Showtime showtimeManager;
    private List<BookingRecord> bookings = new ArrayList<>(); // In-memory storage for bookings
    private Scanner sc = new Scanner(System.in);

    // Constructor to ensure consistent Showtime instance
    public Booking(Showtime showtimeManager) {
        this.showtimeManager = showtimeManager;
    }

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

    // Book a ticket with feedback for whitebox testing
    public String bookTicketWithFeedback(int userID, int showtimeID, int seatNumber) {
        // Validate showtime ID
        if (!showtimeManager.isValidShowtime(showtimeID)) {
            return "Error: Invalid showtime ID.";
        }

        // Fetch the theater's seating capacity for the selected showtime
        int capacity = showtimeManager.getTheatreCapacity(showtimeID);

        // Validate seat number
        if (seatNumber <= 0 || seatNumber > capacity) {
            return "Error: Invalid seat number.";
        }

        // Find already booked seats for this showtime
        List<Integer> bookedSeats = getBookedSeats(showtimeID);
        if (bookedSeats.contains(seatNumber)) {
            return "Error: Seat is already booked.";
        }

        // Add the booking record
        bookings.add(new BookingRecord(userID, showtimeID, seatNumber));
        return "Booking confirmed. Showtime ID: " + showtimeID + ", Seat: " + seatNumber;
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
        System.out.println("--- Available Showtimes ---");
        showtimeManager.showShowtimes();
    }
}
