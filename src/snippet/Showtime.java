package snippet;

import java.sql.Timestamp;
import java.util.*;

public class Showtime {

    private List<ShowtimeRecord> showtimes; // List to store showtime records in memory

    // Constructor to initialize the list
    public Showtime() {
        showtimes = new ArrayList<>();
    }

    // Inner class to represent a Showtime record (you can also separate it into its own class if desired)
    public class ShowtimeRecord {
        int showtimeID;
        int movieID;
        int theaterID;
        Timestamp showtime;

        public ShowtimeRecord(int showtimeID, int movieID, int theaterID, Timestamp showtime) {
            this.showtimeID = showtimeID;
            this.movieID = movieID;
            this.theaterID = theaterID;
            this.showtime = showtime;
        }
    }

    // Method to insert a showtime (simulated insertion into in-memory list)
    public void insertShowtime(int movieID, int theaterID, Timestamp showtime) {
        if (movieID <= 0 || theaterID <= 0 || showtime == null) {
            throw new IllegalArgumentException("Invalid input: movieID, theaterID, and showtime must be provided correctly.");
        }

        int showtimeID = showtimes.size() + 1; // Simple auto-increment for ShowtimeID
        ShowtimeRecord newShowtime = new ShowtimeRecord(showtimeID, movieID, theaterID, showtime);
        showtimes.add(newShowtime);
        System.out.println("Showtime added successfully.");
    }

    // Method to show all showtimes
    public void showShowtimes() {
        if (showtimes.isEmpty()) {
            System.out.println("No showtimes available.");
        } else {
            for (ShowtimeRecord showtime : showtimes) {
                System.out.println("Showtime ID: " + showtime.showtimeID);
                System.out.println("Movie ID: " + showtime.movieID);
                System.out.println("Theater ID: " + showtime.theaterID);
                System.out.println("Showtime: " + showtime.showtime);
                System.out.println("-----------------------------");
            }
        }
    }

    // Method to show specific showtime details by showtimeID
    public void showShowtimeDetails(int showtimeID) {
        if (showtimeID <= 0) {
            throw new IllegalArgumentException("Invalid showtime ID.");
        }

        Optional<ShowtimeRecord> showtime = showtimes.stream()
                .filter(s -> s.showtimeID == showtimeID)
                .findFirst();

        if (showtime.isPresent()) {
            ShowtimeRecord s = showtime.get();
            System.out.println("Showtime ID: " + s.showtimeID);
            System.out.println("Movie ID: " + s.movieID);
            System.out.println("Theater ID: " + s.theaterID);
            System.out.println("Showtime: " + s.showtime);
        } else {
            System.out.println("No showtime found with ID: " + showtimeID);
        }
    }

    // Method to get the theater's seating capacity for a given showtime ID (dummy function for now)
    public int getTheaterCapacity(int showtimeID) {
        if (showtimeID <= 0) {
            throw new IllegalArgumentException("Invalid showtime ID.");
        }

        // Dummy seating capacity for the purpose of testing
        int dummySeatingCapacity = 150; // You can replace this with more logic if needed
        System.out.println("Seating Capacity for Showtime ID " + showtimeID + ": " + dummySeatingCapacity);
        return dummySeatingCapacity;
    }
}
