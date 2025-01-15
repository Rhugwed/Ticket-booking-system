package test.blackbox;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import snippet.Theatre;
import snippet.TheatreManager;

public class TheatreManagerBlackBoxTest1 {

    // Black-box Test Case 1: Test finding a theatre by valid location
    @Test
    void testFindTheatreByLocation_ValidLocation() {
        // Setup
        String location = "Paris";
        TheatreManager manager = new TheatreManager();
        manager.addTheatre(location, 300);  // Add theatre in Paris

        // Test for valid location
        manager.findTheatreByLocation(location); // Expect "Found Theatre"
        
    }

    
    @Test
    void testFindTheatreByLocation_InvalidLocation() {
        // Setup
        String location = "Tokyo";
        TheatreManager manager = new TheatreManager();
        manager.addTheatre("Paris", 300);  // Add theatre in Paris

        // Test for invalid location (theatre does not exist in Tokyo)
        manager.findTheatreByLocation(location); // Expect "No theatre found at location"

        
    }

    
    @Test
    void testFindTheatreByLocation_EmptyLocation() {
        // Setup
        String location = "";
        TheatreManager manager = new TheatreManager();
        manager.addTheatre("Paris", 300);  // Add theatre in Paris

        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            manager.findTheatreByLocation(location);
        });

        assertEquals("Location cannot be empty.", exception.getMessage());
    }

    
    @Test
    void testFindTheatreByLocation_NullLocation() {
        // Setup
        String location = null;
        TheatreManager manager = new TheatreManager();
        manager.addTheatre("Paris", 300);  // Add theatre in Paris

        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            manager.findTheatreByLocation(location);
        });

        assertEquals("Location cannot be empty.", exception.getMessage());
    }

    
    @Test
    void testFindTheatreByLocation_CaseInsensitive() {
        // Setup
        String location = "pArIs";
        TheatreManager manager = new TheatreManager();
        manager.addTheatre("Paris", 300);  // Add theatre in Paris

        // Test for case-insensitive location match
        manager.findTheatreByLocation(location); // Expect "Found Theatre"
        
        
    }

    
    @Test
    void testFindTheatreByLocation_MultipleTheatresSameLocation() {
        // Setup
        String location = "New York";
        TheatreManager manager = new TheatreManager();
        manager.addTheatre(location, 300);  // Add first theatre in New York
        manager.addTheatre(location, 500);  // Add second theatre in New York

        // Test for multiple theatres in the same location
        manager.findTheatreByLocation(location); // Expect multiple "Found Theatre" outputs
        
       
    }

}