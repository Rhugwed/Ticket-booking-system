package test.whitebox;

import org.junit.Test;
import snippet.Admin;
import snippet.MovieManager;
import snippet.Showtime;
import snippet.TheatreManager;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class AdminTest {

    @Test
    public void testAddShowtime_MultipleMovies() {
       
        TheatreManager theatreManager = new TheatreManager();
        MovieManager movieManager = new MovieManager();
        Showtime showtimeManager = new Showtime();

        // Step 2: Add Test Data
        movieManager.addMovie("Inception", "Sci-Fi", 148);
        movieManager.addMovie("The Avengers2", "Action", 136); 
        theatreManager.addTheatre("Downtown", 300);       

        
        ByteArrayInputStream inputForFirstMovie = new ByteArrayInputStream("1\n1\n18\n30\n".getBytes());
        System.setIn(inputForFirstMovie);

        
        Admin admin = new Admin(theatreManager, movieManager, showtimeManager);
        admin.resetScanner(); 

        
        admin.addShowtime();

       
        ByteArrayInputStream inputForSecondMovie = new ByteArrayInputStream("2\n1\n20\n00\n".getBytes());
        System.setIn(inputForSecondMovie);
        admin.resetScanner(); 

        
        admin.addShowtime();

        
        assertEquals(2, showtimeManager.getShowtimeCount()); 
    }
}
