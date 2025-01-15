package test.blackbox;

import org.junit.Test;
import snippet.Admin;
import snippet.MovieManager;
import snippet.Showtime;
import snippet.TheatreManager;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class AdminBlackBoxTest {

	@Test
	public void testAddTheatre_ValidInput() {
	    // Create shared instances of managers
	    TheatreManager theatreManager = new TheatreManager();
	    MovieManager movieManager = new MovieManager();
	    Showtime showtimeManager = new Showtime();

	    // Simulated input for location and seating capacity
	    String simulatedInput = "Downtown\n300\n"; // Correct sequence of inputs
	    ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
	    System.setIn(in);

	    // Create Admin object
	    Admin admin = new Admin(theatreManager, movieManager, showtimeManager);

	    // Call addTheatre()
	    admin.addTheatre();

	    // Assert that the theatre was added successfully
	    assertEquals(1, theatreManager.getTheatreCount());
	}



    @Test
    public void testAddShowtime_ValidInput() {
        // Create supporting objects required for Admin
        TheatreManager theatreManager = new TheatreManager();
        MovieManager movieManager = new MovieManager();
        Showtime showtimeManager = new Showtime();

        // Add initial data
        theatreManager.addTheatre("Downtown", 300); // Theatre ID = 1
        movieManager.addMovie("Inception", "Sci-Fi", 148); // Movie ID = 1

        // Prepare input for showtime details
        String input = "1\n1\n20\n30\n"; // Movie ID = 1, Theatre ID = 1, Time = 20:30
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Create Admin object
        Admin admin = new Admin(theatreManager, movieManager, showtimeManager);

        // Call addShowtime() (it will use the simulated input)
        admin.addShowtime();

        // Validate that the showtime was added successfully
        assertEquals(1, showtimeManager.getShowtimeCount());
    }
}
