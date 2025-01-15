package test.blackbox;

import org.junit.Test;
import snippet.MovieManager;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MovieManagerBlackBoxTest2 {

    @Test
    public void testShowMovies_WithMovies() {
        // Arrange
        MovieManager movieManager = new MovieManager();
        movieManager.addMovie("Avatar", "Action", 162);
        movieManager.addMovie("Frozen", "Animation", 102);

        // Redirect console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        movieManager.showMovies();

        // Capture and verify output
        String actualOutput = out.toString().trim();
        String expectedOutput = "Movies List:\n" +
                "Title: Avatar, Genre: Action, Duration: 162 minutes\n" +
                "Title: Frozen, Genre: Animation, Duration: 102 minutes";

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testShowMovies_EmptyList() {
        // Arrange
        MovieManager movieManager = new MovieManager();

        // Redirect console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        movieManager.showMovies();

        // Capture and verify output
        String actualOutput = out.toString().trim();
        String expectedOutput = "No movies available.";

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }
}
