package test.whitebox;

import static org.junit.Assert.*; // For assertions
import org.junit.Test;            // For @Test annotation
import snippet.TheatreManager;

public class TheatreManagerTest {
	// Test case 1: Adding new theatre
	@Test 
	public void testAddTheatre_ValidInputs() {
	    TheatreManager manager = new TheatreManager();
	    manager.addTheatre("Odion", 500);
	    assertEquals(1, manager.getTheatreCount()); 
	    assertEquals("Odion", manager.getTheatre(0).getLocation());
	    assertEquals(500, manager.getTheatre(0).getSeatingCapacity());
	}

    
    // Test case 2: Add a theatre with the empty location
    @Test(expected = IllegalArgumentException.class)
    public void testAddTheatre_EmptyLocation() {
        TheatreManager manager = new TheatreManager(); 
        manager.addTheatre("", 500); // 
    }

    // Test case for checking negative seating capacity
    @Test(expected = IllegalArgumentException.class)
    public void testAddTheatre_NegativeSeatingCapacity() {
        TheatreManager manager = new TheatreManager();     
        manager.addTheatre("PVR", -50); 
    }
}
