package test.blackbox;

import org.junit.Test;
import snippet.Movie;
import snippet.MovieManager;

import static org.junit.Assert.*;

public class MovieManagerBlackBoxTest3 {

    @Test
    public void testSearchMovie_Found() {
        // Arrange
        MovieManager movieManager = new MovieManager();
        movieManager.addMovie("Inception", "Sci-Fi", 148);

        // Act
        Movie result = movieManager.searchMovie("Inception");

        // Assert
        assertNotNull(result);
        assertEquals("Inception", result.getTitle());
        assertEquals("Sci-Fi", result.getGenre());
        assertEquals(148, result.getDuration());
    }

    @Test
    public void testSearchMovie_NotFound() {
        // Arrange
        MovieManager movieManager = new MovieManager();
        movieManager.addMovie("Inception", "Sci-Fi", 148);

        // Act
        Movie result = movieManager.searchMovie("Avatar");

        // Assert
        assertNull(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchMovie_InvalidInput_Null() {
        // Arrange
        MovieManager movieManager = new MovieManager();

        // Act
        movieManager.searchMovie(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchMovie_InvalidInput_Empty() {
        // Arrange
        MovieManager movieManager = new MovieManager();

        // Act
        movieManager.searchMovie("");
    }
}