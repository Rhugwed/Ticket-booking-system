package test.blackbox;
import org.junit.Test;
import snippet.Theatre;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TheatreBlackBoxTest {

    @Test
    public void testInsertTheatre_ValidInputs() {
        // Arrange
        Theatre theatre = new Theatre("Downtown", 300);

        // Redirect console output to verify the output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        theatre.insertTheatre("Uptown", 500);

        // Capture and normalize output
        String actualOutput = out.toString().trim();
        String expectedOutput = "Theatre details set: Location = Uptown, Seating Capacity = 500";

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertTheatre_NullLocation() {
        // Arrange
        Theatre theatre = new Theatre("Downtown", 300);

        // Act
        theatre.insertTheatre(null, 500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertTheatre_EmptyLocation() {
        // Arrange
        Theatre theatre = new Theatre("Downtown", 300);

        // Act
        theatre.insertTheatre("", 500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertTheatre_NegativeSeatingCapacity() {
        // Arrange
        Theatre theatre = new Theatre("Downtown", 300);

        // Act
        theatre.insertTheatre("Uptown", -10);
    }
}