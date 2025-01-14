package snippet;

import java.time.LocalDateTime;
import java.util.*;

public class Showtime {

    private List<ShowtimeDetails> showtimes;
    private int nextShowtimeID = 1; 

    
    public Showtime() {
        showtimes = new ArrayList<>();
    }

    
    public class ShowtimeDetails {
        int showtimeID;
        int movieID;
        int theatreID;
        LocalDateTime showtime;

        public ShowtimeDetails(int showtimeID, int movieID, int theatreID, LocalDateTime showtime) {
            this.showtimeID = showtimeID;
            this.movieID = movieID;
            this.theatreID = theatreID;
            this.showtime = showtime;
        }

        @Override
        public String toString() {
            return "Showtime ID: " + showtimeID + ", Movie ID: " + movieID + ", Theatre ID: " + theatreID + ", Showtime: " + showtime;
        }
    }

    
    public void insertShowtime(int movieID, int theatreID, LocalDateTime showtime) {
        if (movieID <= 0 || theatreID <= 0 || showtime == null) {
            throw new IllegalArgumentException("Invalid input: movieID, theatreID, and showtime must be provided correctly.");
        }

        ShowtimeDetails newShowtime = new ShowtimeDetails(nextShowtimeID++, movieID, theatreID, showtime);
        showtimes.add(newShowtime);
        System.out.println("Showtime added successfully: " + newShowtime);
    }

    
    public void showShowtimes() {
        if (showtimes.isEmpty()) {
            System.out.println("No showtimes available.");
        } else {
            System.out.println("List of Showtimes:");
            for (ShowtimeDetails showtime : showtimes) {
                System.out.println(showtime);
                System.out.println("-----------------------------");
            }
        }
    }

    
    public void showShowtimeDetails(int showtimeID) {
        if (showtimeID <= 0) {
            throw new IllegalArgumentException("Invalid showtime ID.");
        }

        Optional<ShowtimeDetails> showtime = showtimes.stream()
                .filter(s -> s.showtimeID == showtimeID)
                .findFirst();

        if (showtime.isPresent()) {
            System.out.println(showtime.get());
        } else {
            System.out.println("No showtime found with ID: " + showtimeID);
        }
    }

    
    public int getTheatreCapacity(int showtimeID) {
        if (showtimeID <= 0) {
            throw new IllegalArgumentException("Invalid showtime ID.");
        }

        
        int dummySeatingCapacity = 150; 
        System.out.println("Seating Capacity for Showtime ID " + showtimeID + ": " + dummySeatingCapacity);
        return dummySeatingCapacity;
    }

    
    public void removeShowtime(int showtimeID) {
        if (showtimeID <= 0) {
            throw new IllegalArgumentException("Invalid showtime ID.");
        }

        boolean removed = showtimes.removeIf(s -> s.showtimeID == showtimeID);
        if (removed) {
            System.out.println("Showtime with ID " + showtimeID + " removed successfully.");
        } else {
            System.out.println("No showtime found with ID: " + showtimeID);
        }
    }


    public int getShowtimeCount() {
        return showtimes.size();
    }

    public int removeExpiredShowtimes() {
        int initialSize = showtimes.size();
        LocalDateTime now = LocalDateTime.now();
        showtimes.removeIf(showtime -> showtime.showtime.isBefore(now));
        return initialSize - showtimes.size(); 
    }
}