package snippet;

import java.util.Scanner;

public class User {
    // Instance fields
    private String name, username, password, address, phone;
    private int choice;
    private Scanner sc = new Scanner(System.in);

    // Dependencies
    private Showtime showtimeManager = new Showtime(); // Manage showtimes
    private Booking bookingManager = new Booking(); // Manage ticket bookings

    // User menu
    public void userMenu(int userID) {
        while (true) {
            System.out.println("\n---------- User Menu ----------");
            System.out.println("1. View All Showtimes");
            System.out.println("2. Book a Ticket");
            System.out.println("3. View My Ticket Bookings");
            System.out.println("4. Cancel a Ticket Booking");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                // Case 1: View all showtimes
                case 1:
                    viewShowtimes();
                    break;

                // Case 2: Book a ticket
                case 2:
                    bookTicket(userID);
                    break;

                // Case 3: View ticket bookings
                case 3:
                    viewTicketBookings(userID);
                    break;

                // Case 4: Cancel a ticket booking
                case 4:
                    cancelTicketBooking(userID);
                    break;

                // Case 5: Exit
                case 5:
                    System.out.println("Exiting User Menu. Goodbye!");
                    return;

                // Default: Invalid choice
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Case 1: View all showtimes
    private void viewShowtimes() {
        showtimeManager.showShowtimes();
    }

    // Case 2: Book a ticket
    private void bookTicket(int userID) {
        try {
            System.out.print("Enter Showtime ID to book: ");
            int showtimeID = sc.nextInt();

            bookingManager.bookTicket(userID, showtimeID);
            System.out.println("Ticket booked successfully.");
        } catch (Exception e) {
            System.out.println("Error booking ticket: " + e.getMessage());
        }
    }

    // Case 3: View ticket bookings
    private void viewTicketBookings(int userID) {
        try {
            bookingManager.seeTicket(userID);
        } catch (Exception e) {
            System.out.println("Error viewing ticket bookings: " + e.getMessage());
        }
    }

    // Case 4: Cancel a ticket booking
    private void cancelTicketBooking(int userID) {
        try {
            System.out.print("Enter Booking ID to cancel: ");
            int bookingID = sc.nextInt();

            bookingManager.cancelTicket(userID, bookingID);
            System.out.println("Ticket canceled successfully.");
        } catch (Exception e) {
            System.out.println("Error canceling ticket: " + e.getMessage());
        }
    }
}