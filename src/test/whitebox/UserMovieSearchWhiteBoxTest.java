package test.whitebox;

import org.junit.Test;
import snippet.Movie;
import snippet.MovieManager;

import static org.junit.Assert.*;

public class UserMovieSearchWhiteBoxTest {

    @Test
    public void testSearchMovie_ValidTitle_MovieFound() {
        MovieManager movieManager = new MovieManager();
        movieManager.addMovie("Interstellar", "Sci-Fi", 169);
        movieManager.addMovie("The Matrix", "Action", 136);

        Movie result = movieManager.searchMovie("The Matrix");
        assertNotNull("Movie should be found", result);
        assertEquals("The Matrix", result.getTitle());
    }

    @Test
    public void testSearchMovie_ValidTitle_MovieNotFound() {
        MovieManager movieManager = new MovieManager();
        movieManager.addMovie("Titanic", "Romance", 195);

        Movie result = movieManager.searchMovie("Avatar");
        assertNull("Movie should not be found", result);
    }

    @Test
    public void testSearchMovie_NullTitle_ExceptionThrown() {
        try {
            MovieManager movieManager = new MovieManager();
            movieManager.searchMovie(null);
            fail("Expected IllegalArgumentException for null title");
        } catch (IllegalArgumentException e) {
            assertEquals("Title cannot be null or empty.", e.getMessage());
        }
    }

    @Test
    public void testSearchMovie_EmptyTitle_ExceptionThrown() {
        try {
            MovieManager movieManager = new MovieManager();
            movieManager.searchMovie(" ");
            fail("Expected IllegalArgumentException for empty title");
        } catch (IllegalArgumentException e) {
            assertEquals("Title cannot be null or empty.", e.getMessage());
        }
    }
}
