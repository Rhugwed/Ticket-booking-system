package test.blackbox;

import org.junit.Test;
import snippet.Movie;
import snippet.MovieManager;

import static org.junit.Assert.*;

public class SearchMovieTest {

    @Test
    public void testSearchMovie_ExistingMovie() {
        MovieManager movieManager = new MovieManager();
        movieManager.addMovie("Inception", "Sci-Fi", 148);

        Movie result = movieManager.searchMovie("Inception");
        assertNotNull("Movie should be found", result);
        assertEquals("Inception", result.getTitle());
    }

    @Test
    public void testSearchMovie_NonExistingMovie() {
        MovieManager movieManager = new MovieManager();

        Movie result = movieManager.searchMovie("Avatar");
        assertNull("Movie should not be found", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchMovie_NullTitle() {
        MovieManager movieManager = new MovieManager();
        movieManager.searchMovie(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchMovie_EmptyTitle() {
        MovieManager movieManager = new MovieManager();
        movieManager.searchMovie("");
    }
}
