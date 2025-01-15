package test.whitebox;

import org.junit.Test;
import snippet.MovieManager;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MovieManagerWhiteBoxTest2 {

    @Test
    public void testShowMovies_WithMovies() {
        // Arrange
        MovieManager movieManager = new MovieManager();
        movieManager.addMovie("Inception", "Sci-Fi", 148);
        movieManager.addMovie("Titanic", "Romance", 195);

        // Redirect console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        movieManager.showMovies();

        // Normalize output
        String actualOutput = out.toString().trim();
        String expectedOutput = String.join(System.lineSeparator(),
                "Movies List:",
                "Title: Inception, Genre: Sci-Fi, Duration: 148 minutes",
                "Title: Titanic, Genre: Romance, Duration: 195 minutes"
        );

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testShowMovies_NoMovies() {
        // Arrange
        MovieManager movieManager = new MovieManager();

        // Redirect console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        movieManager.showMovies();

        // Normalize output
        String actualOutput = out.toString().trim();
        String expectedOutput = "No movies available.";

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }
}
