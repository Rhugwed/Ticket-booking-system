package test.whitebox;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import snippet.Theatre; // Ensure this matches your actual package structure
import snippet.TheatreManager;

public class TheatreManagerTest3 {

    // Create a ByteArrayOutputStream to capture System.out.println output
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    // Helper method to set up the test environment
    private void setupOutputCapture() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testFindTheatreByLocation_Found() {
        setupOutputCapture(); // Capture output
        
        // Test input where the location exists in the theatres list
        String location = "New York";
        TheatreManager manager = new TheatreManager();
        manager.addTheatre(location, 200); // Add a theatre
        manager.findTheatreByLocation(location); // Call the method with the valid location

        // Verify that the output contains the found theatre
        assertTrue(outputStream.toString().contains("Found Theatre"));
    }

    @Test
    void testFindTheatreByLocation_NotFound() {
        setupOutputCapture(); // Capture output

        // Test input where no theatre is found for the given location
        String location = "Los Angeles";
        TheatreManager manager = new TheatreManager();
        manager.addTheatre("New York", 200); // Add theatre with a different location
        manager.findTheatreByLocation(location); // Call the method with the non-existent location

        // Verify that the output mentions no theatres found
        assertTrue(outputStream.toString().contains("No theatre found at location"));
    }

    @Test
    void testFindTheatreByLocation_EmptyLocation() {
        // Test input where location is an empty string
        String location = "";
        TheatreManager manager = new TheatreManager();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            manager.findTheatreByLocation(location); // Call the method with an empty location
        });

        // Verify that the exception message is correct
        assertEquals("Location cannot be empty.", exception.getMessage());
    }

    @Test
    void testFindTheatreByLocation_NullLocation() {
        // Test input where location is null
        String location = null;
        TheatreManager manager = new TheatreManager();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            manager.findTheatreByLocation(location); // Call the method with a null location
        });

        // Verify that the exception message is correct
        assertEquals("Location cannot be empty.", exception.getMessage());
    }

    @Test
    void testFindTheatreByLocation_CaseInsensitive() {
        setupOutputCapture(); // Capture output

        // Test input with case-insensitive location match
        String location = "new york";
        TheatreManager manager = new TheatreManager();
        manager.addTheatre("New York", 200); // Add theatre in New York
        manager.findTheatreByLocation(location); // Call the method with the location in different case

        // Verify that the output contains the found theatre (case-insensitive check)
        assertTrue(outputStream.toString().contains("Found Theatre"));
    }

    @Test
    void testFindTheatreByLocation_ValidLocationWithMultipleTheatres() {
        setupOutputCapture(); // Capture output

        // Test input where multiple theatres exist in the same location
        String location = "London";
        TheatreManager manager = new TheatreManager();
        manager.addTheatre(location, 300);
        manager.addTheatre(location, 500); // Add another theatre in the same location
        manager.findTheatreByLocation(location); // Call the method with the valid location

        // Verify that both theatres in London are found
        assertTrue(outputStream.toString().contains("Found Theatre"));
    }

}