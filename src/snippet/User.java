package snippet;

import java.util.Scanner;

public class User {

    // Instance fields for user management
    private String name, username, address, phone;
    private int choice;
    private Scanner sc = new Scanner(System.in);

    // Dependencies
    private Booking bookingManager = new Booking(); // Manages bookings
    private Showtime showtimeManager = new Showtime(); // Manages showtimes

    // Constructor to initialize user details
    public User(String name, String username, String password, String address, String phone) {
        this.name = name;
        this.username = username;
        this.address = address;
        this.phone = phone;
    }

    // Method to display user information
    public void displayUserInfo() {
        System.out.println("User Information:");
        System.out.println("Name: " + name);
        System.out.println("Username: " + username);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
    }

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
                case 1:
                    viewShowtimes(); // Call showtimes directly from Showtime
                    break;
                case 2:
                    bookTicket(userID); // Delegate to Booking class
                    break;
                case 3:
                    viewTicketBookings(userID); // Delegate to Booking class
                    break;
                case 4:
                    cancelTicketBooking(userID); // Delegate to Booking class
                    break;
                case 5:
                    System.out.println("Exiting User Menu. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Case 1: View all showtimes
    private void viewShowtimes() {
        showtimeManager.showShowtimes(); // Display showtimes using Showtime class
    }

    // Case 2: Book a ticket
    private void bookTicket(int userID) {
        bookingManager.bookTicket(userID); // Delegate to Booking class
    }

    // Case 3: View ticket bookings
    private void viewTicketBookings(int userID) {
        bookingManager.seeTicket(userID); // Delegate to Booking class
    }

    // Case 4: Cancel a ticket booking
    private void cancelTicketBooking(int userID) {
        bookingManager.cancelTicket(userID); // Delegate to Booking class
    }
}
