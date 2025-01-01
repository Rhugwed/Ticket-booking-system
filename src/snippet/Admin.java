package snippet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Admin {

    // Instance fields
    private Scanner sc = new Scanner(System.in);
    private int choice;
    private String location;
    private int seatingCapacity, theaterID, movieID, showtimeHour, showtimeMinute;

    // Objects of other classes
    private Showtime showtimeManager = new Showtime();
    private List<Theatre> theatres = new ArrayList<>(); // In-memory storage for theatres

    // Admin menu
    public void adminMenu() {
        while (true) {
            System.out.println("\n---------- Admin Menu ----------");
            System.out.println("1. Add Theater");
            System.out.println("2. View All Theaters");
            System.out.println("3. Add Showtime for a Movie");
            System.out.println("4. View All Showtimes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addTheater();
                    break;
                case 2:
                    viewTheaters();
                    break;
                case 3:
                    addShowtime();
                    break;
                case 4:
                    viewShowtimes();
                    break;
                case 5:
                    System.out.println("Exiting Admin Menu. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Case 1: Add a theater
    private void addTheater() {
        try {
            System.out.print("Enter theater location: ");
            sc.nextLine(); // Clear buffer
            location = sc.nextLine();
            System.out.print("Enter seating capacity: ");
            seatingCapacity = sc.nextInt();

            Theatre theatre = new Theatre(location, seatingCapacity);
            theatres.add(theatre);
            System.out.println("Theater added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding theater: " + e.getMessage());
        }
    }

    // Case 2: View all theaters
    private void viewTheaters() {
        if (theatres.isEmpty()) {
            System.out.println("No theaters available.");
        } else {
            System.out.println("Theater List:");
            for (int i = 0; i < theatres.size(); i++) {
                System.out.println("Theater ID: " + (i + 1));
                theatres.get(i).showTheatres();
                System.out.println("-----------------------------");
            }
        }
    }

    // Case 3: Add showtime for a movie
    private void addShowtime() {
        try {
            System.out.print("Enter Movie ID: ");
            movieID = sc.nextInt();
            System.out.print("Enter Theater ID (from the list): ");
            theaterID = sc.nextInt();

            if (theaterID <= 0 || theaterID > theatres.size()) {
                System.out.println("Invalid Theater ID. Please try again.");
                return;
            }

            System.out.print("Enter Showtime Hour (24-hour format): ");
            showtimeHour = sc.nextInt();
            System.out.print("Enter Showtime Minute: ");
            showtimeMinute = sc.nextInt();

            LocalDateTime showtime = LocalDateTime.now()
                .withHour(showtimeHour)
                .withMinute(showtimeMinute)
                .withSecond(0);

            showtimeManager.insertShowtime(movieID, theaterID, showtime);
            System.out.println("Showtime added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding showtime: " + e.getMessage());
        }
    }

    // Case 4: View all showtimes
    private void viewShowtimes() {
        showtimeManager.showShowtimes();
    }
}
