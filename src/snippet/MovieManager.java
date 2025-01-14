package test.whitebox;

import static org.junit.Assert.*; 
import org.junit.Test;            // For @Test annotation
import snippet.MovieManager;      
import snippet.Movie;             

public class MovieManagerTest {

    // Test Case 1: Add a movie with valid inputs
    @Test
    public void testAddMovie_ValidInputs() {
        MovieManager manager = new MovieManager();

        // Act: Add a valid movie
        manager.addMovie("Inception", "Sci-Fi", 148);

        // Assert: Verify the movie count and details
        assertEquals(1, manager.getMovieCount()); 
        Movie movie = manager.getMovie(0);       // Retrieve the first movie
        assertEquals("Inception", movie.getTitle());
        assertEquals("Sci-Fi", movie.getGenre());
        assertEquals(148, movie.getDuration());
    }

    // Test Case 2: Add a movie with an empty title
    @Test(expected = IllegalArgumentException.class)
    public void testAddMovie_EmptyTitle() {
        MovieManager manager = new MovieManager();

        // Act: Add a movie with an empty title
        manager.addMovie("", "Sci-Fi", 148); 
    }

    // Test Case 3: Add a movie with a negative duration
    @Test(expected = IllegalArgumentException.class)
    public void testAddMovie_NegativeDuration() {
        MovieManager manager = new MovieManager();

        // Act: Add a movie with a negative duration
        manager.addMovie("Inception", "Sci-Fi", -148); 
    }
   
        
    
 // Test Case 4: Prevent Movie duplication
    @Test(expected = IllegalArgumentException.class)
    public void testAddMovie_DuplicateMovie() {
        MovieManager manager = new MovieManager();

        
        manager.addMovie("Avengers", "Action", 160);

        
        manager.addMovie("Avengers", "Action", 160); // Should throw IllegalArgumentException
    }



}