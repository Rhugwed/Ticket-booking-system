package test.blackbox;

import org.junit.Test;
import snippet.Theatre;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class TheatreBlackBoxTest2 {

    @Test
    public void testShowTheatres_DisplayDetails() {
        // Arrange
        Theatre theatre = new Theatre("Uptown", 150);

        // Redirect console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        theatre.showTheatres();

        // Capture output
        String actualOutput = out.toString().trim();

        // Assert: Check that the expected details are part of the output
        assertTrue(actualOutput.contains("Location:Uptown"));
        assertTrue(actualOutput.contains("Seating Capacity:150"));
    }

}