package test.whitebox;

import org.junit.Test;
import snippet.Movie;
import snippet.MovieManager;

import static org.junit.Assert.*;

public class MovieManagerWhiteBoxTest3 {

    @Test
    public void testSearchMovie_ValidTitle_Found() {
        // Arrange
        MovieManager movieManager = new MovieManager();
        movieManager.addMovie("Inception", "Sci-Fi", 148);

        // Act
        Movie result = movieManager.searchMovie("Inception");

        // Assert
        assertNotNull(result);
        assertEquals("Inception", result.getTitle());
    }

    @Test
    public void testSearchMovie_ValidTitle_NotFound() {
        // Arrange
        MovieManager movieManager = new MovieManager();
        movieManager.addMovie("Inception", "Sci-Fi", 148);

        // Act
        Movie result = movieManager.searchMovie("Titanic");

        // Assert
        assertNull(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchMovie_NullTitle() {
        // Arrange
        MovieManager movieManager = new MovieManager();

        // Act
        movieManager.searchMovie(null);

        // Assert: Exception is expected
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchMovie_EmptyTitle() {
        // Arrange
        MovieManager movieManager = new MovieManager();

        // Act
        movieManager.searchMovie("");

        // Assert: Exception is expected
    }
}