package test.whitebox;

import org.junit.Test;
import snippet.Admin;
import snippet.MovieManager;
import snippet.Showtime;
import snippet.TheatreManager;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class AdminTest2 {

    @Test
    public void testAddShowtime_InvalidInputs() {
       
        TheatreManager theatreManager = new TheatreManager();
        MovieManager movieManager = new MovieManager();
        Showtime showtimeManager = new Showtime();

       
        movieManager.addMovie("Inception", "Sci-Fi", 148); 
        theatreManager.addTheatre("Downtown", 300);        
        
        ByteArrayInputStream invalidMovieInput = new ByteArrayInputStream("99\n1\n18\n30\n".getBytes()); 
        System.setIn(invalidMovieInput);

        Admin admin = new Admin(theatreManager, movieManager, showtimeManager);
        admin.resetScanner();
        admin.addShowtime(); 

       
        assertEquals(0, showtimeManager.getShowtimeCount());

       
        ByteArrayInputStream invalidTheatreInput = new ByteArrayInputStream("1\n99\n18\n30\n".getBytes()); // Theatre ID = 99 (invalid)
        System.setIn(invalidTheatreInput);

        admin.resetScanner();
        admin.addShowtime(); 

       
        assertEquals(0, showtimeManager.getShowtimeCount());

     
        ByteArrayInputStream invalidTimeInput = new ByteArrayInputStream("1\n1\n-5\n60\n".getBytes()); // Invalid hour and minute
        System.setIn(invalidTimeInput);

        admin.resetScanner();
        admin.addShowtime(); 

        
        assertEquals(0, showtimeManager.getShowtimeCount());
    }
}
