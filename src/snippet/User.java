package snippet;

import java.util.Scanner;

public class User {

    // Instance fields for user management
    private String name;
    private String username;
    private String address;
    private String phone;
    private int choice;
    private transient Scanner sc; // Mark as transient to avoid serialization issues

    // Dependencies
    private Showtime showtimeManager; // Define Showtime first
    private Booking bookingManager;   // Booking depends on Showtime
	private String password;

    // Constructor to initialize user details and dependencies
    public User(String name, String username, String password, String address, String phone) {
        this.name = name;
        this.username = username;
        this.address = address;
        this.phone = phone;
        this.password= password;
        // Initialize dependencies
        this.sc = new Scanner(System.in);
        this.showtimeManager = new Showtime();
        this.bookingManager = new Booking(showtimeManager);
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
        // Ensure Scanner is initialized
        if (sc == null) {
            sc = new Scanner(System.in);
        }

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
                    viewShowtimes();
                    break;
                case 2:
                    bookTicket(userID);
                    break;
                case 3:
                    viewTicketBookings(userID);
                    break;
                case 4:
                    cancelTicketBooking(userID);
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
    public void viewShowtimes() {
        System.out.println("--- Available Showtimes ---");
        showtimeManager.showShowtimes();
    }

    // Case 2: Book a ticket
    public void bookTicket(int userID) {
        System.out.println("--- Book a Ticket ---");

        // Display available showtimes
        viewShowtimes();

        System.out.print("Enter Showtime ID: ");
        int showtimeID = sc.nextInt();

        System.out.print("Enter Seat Number: ");
        int seatNumber = sc.nextInt();

        // Attempt to book a ticket
        String result = bookingManager.bookTicketWithFeedback(userID, showtimeID, seatNumber);
        System.out.println(result);
    }

    // Case 3: View ticket bookings
    public void viewTicketBookings(int userID) {
        System.out.println("--- Your Bookings ---");
        bookingManager.seeTicket(userID);
    }

    // Case 4: Cancel a ticket booking
    public void cancelTicketBooking(int userID) {
        System.out.println("--- Cancel a Ticket ---");
        bookingManager.cancelTicket(userID);
    }

    // Getters for username and other fields
    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
 // Getter for password
    public String getPassword() {
        return password;
    }
}