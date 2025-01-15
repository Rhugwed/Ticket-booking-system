package snippet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UpdatedMovieTest {

    private MovieManager movieManager;

    @BeforeEach
    public void setup() {
        movieManager = new MovieManager();
        movieManager.addMovie("KGF", "Action", 100);
    }

    @Test
    public void testValidIndex() {
        assertDoesNotThrow(() -> movieManager.updateMovie(0, "Valid Title", "Valid Genre", 150));
    }

    @Test
    public void testInvalidDurationNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            movieManager.updateMovie(0, "La la land", "Comedy", -10);
        });
        assertEquals("New duration must be greater than zero.", exception.getMessage());
    }
}