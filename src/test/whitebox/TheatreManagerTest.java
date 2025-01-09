package test.whitebox;

import static org.junit.Assert.*; // For assertions
import org.junit.Test;            // For @Test annotation

import snippet.Theatre;
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
    @Test
    public void testUpdateTheatre_ValidInputs() {
        TheatreManager manager = new TheatreManager();

        manager.addTheatre("Luxe", 300);
        manager.updateTheatre(0, "Cinepolis", 400);
        Theatre updatedTheatre = manager.getTheatre(0);
        assertEquals("Cinepolis", updatedTheatre.getLocation());
        assertEquals(400, updatedTheatre.getSeatingCapacity());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateTheatre_EmptyLocation() {
        TheatreManager manager = new TheatreManager();
        manager.addTheatre("Luxe", 300);
        manager.updateTheatre(0, "", 400);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateTheatre_NegativeSeatingCapacity() {
        TheatreManager manager = new TheatreManager();
        manager.addTheatre("Luxe", 300);
        manager.updateTheatre(0, "Cinepolis", -10);
    }

    
}
