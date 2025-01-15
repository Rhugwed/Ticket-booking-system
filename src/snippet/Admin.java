package snippet;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Admin {

    private TheatreManager theatreManager;
    private MovieManager movieManager;
    private Showtime showtimeManager;
    private Scanner sc;

    private String username;
    private String password;

    public Admin(TheatreManager theatreManager, MovieManager movieManager, Showtime showtimeManager) {
        this.theatreManager = theatreManager;
        this.movieManager = movieManager;
        this.showtimeManager = showtimeManager;
        this.sc = new Scanner(System.in);
    }

    public Admin(String username, String password, TheatreManager theatreManager, MovieManager movieManager, Showtime showtimeManager) {
        this.username = username;
        this.password = password;
        this.theatreManager = theatreManager;
        this.movieManager = movieManager;
        this.showtimeManager = showtimeManager;
        this.sc = new Scanner(System.in);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void resetScanner() {
        sc = new Scanner(System.in);
    }

    public void adminMenu() {
        while (true) {
            System.out.println("\n---------- Admin Menu ----------");
            System.out.println("1. Add Theatre");
            System.out.println("2. View All Theatres");
            System.out.println("3. Add Showtime for a Movie");
            System.out.println("4. View All Showtimes");
            System.out.println("5. Count Total Showtimes");
            System.out.println("6. Remove All Expired Showtimes");
            System.out.println("7. Update Theatre");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addTheatre();
                    break;
                case 2:
                    viewTheatres();
                    break;
                case 3:
                    addShowtime();
                    break;
                case 4:
                    viewShowtimes();
                    break;
                case 5:
                    countShowtimes();
                    break;
                case 6:
                    removeExpiredShowtimes();
                    break;
                case 7:
                    updateTheatre();
                    break;
                case 8:
                    System.out.println("Exiting Admin Menu. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void addTheatre() {
        try {
            System.out.print("Enter theatre location: ");
            String location = sc.next(); // Use next() to directly capture a single word or token
            sc.nextLine(); // Clear the remaining buffer
            System.out.println("Debug: Location entered - " + location);

            System.out.print("Enter seating capacity: ");
            int seatingCapacity = sc.nextInt();
            System.out.println("Debug: Seating capacity entered - " + seatingCapacity);

            theatreManager.addTheatre(location, seatingCapacity);
            System.out.println("Theatre added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding theatre: " + e.getMessage());
            e.printStackTrace();
        }
    }



    public void viewTheatres() {
        theatreManager.showAllTheatres();
    }

    public void addShowtime() {
        try {
            System.out.print("Enter Movie ID: ");
            int movieID = sc.nextInt();
            System.out.println("Debug: Movie ID entered: " + movieID);

            if (!movieManager.isValidMovie(movieID)) {
                System.out.println("Invalid Movie ID.");
                return;
            }

            System.out.print("Enter Theatre ID (from the list): ");
            int theatreID = sc.nextInt();
            System.out.println("Debug: Theatre ID entered: " + theatreID);

            if (!theatreManager.isValidTheatre(theatreID)) {
                System.out.println("Invalid Theatre ID.");
                return;
            }

            System.out.print("Enter Showtime Hour (24-hour format): ");
            int hour = sc.nextInt();
            System.out.print("Enter Showtime Minute: ");
            int minute = sc.nextInt();
            System.out.println("Debug: Showtime entered: " + hour + ":" + minute);

            LocalDateTime showtime = LocalDateTime.now().withHour(hour).withMinute(minute).withSecond(0);
            showtimeManager.insertShowtime(movieID, theatreID, showtime);
            System.out.println("Showtime added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding showtime: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void viewShowtimes() {
        showtimeManager.showShowtimes();
    }

    public void countShowtimes() {
        int totalShowtimes = showtimeManager.getShowtimeCount();
        if (totalShowtimes == 0) {
            System.out.println("No showtimes available.");
        } else {
            System.out.println("Total number of showtimes: " + totalShowtimes);
        }
    }

    public void removeExpiredShowtimes() {
        int removedCount = showtimeManager.removeExpiredShowtimes();
        if (removedCount == 0) {
            System.out.println("No expired showtimes to remove.");
        } else {
            System.out.println(removedCount + " expired showtime(s) removed.");
        }
    }

    // Additional Feature: Update an existing theatre
    public void updateTheatre() {
        try {
            System.out.print("Enter Theatre ID to update: ");
            int theatreID = sc.nextInt();

            if (!theatreManager.isValidTheatre(theatreID)) {
                System.out.println("Invalid Theatre ID.");
                return;
            }

            System.out.print("Enter new location: ");
            sc.nextLine(); // Clear buffer
            String newLocation = sc.nextLine();

            System.out.print("Enter new seating capacity: ");
            int newCapacity = sc.nextInt();

            theatreManager.updateTheatre(theatreID - 1, newLocation, newCapacity); // Adjust for 0-based indexing
            System.out.println("Theatre updated successfully.");
        } catch (Exception e) {
            System.out.println("Error updating theatre: " + e.getMessage());
        }
    }
}