package test.blackbox;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import snippet.Movie;
import snippet.MovieManager;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerBlackBoxTest {

    private MovieManager movieManager;

    @BeforeEach
    public void setup() {
        movieManager = new MovieManager();
        movieManager.addMovie("Original Title", "Original Genre", 100);
    }

    @Test
    public void testUpdateValidMovie() {
        movieManager.updateMovie(0, "New Title", "New Genre", 120);
        Movie updatedMovie = movieManager.getMovie(0);

        assertEquals("New Title", updatedMovie.getTitle());
        assertEquals("New Genre", updatedMovie.getGenre());
        assertEquals(120, updatedMovie.getDuration());
    }

    @Test
    public void testUpdateInvalidIndexOutOfBounds() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            movieManager.updateMovie(10, "New Title", "New Genre", 120);
        });
        assertEquals("Invalid index. No such movie exists.", exception.getMessage());
    }
}