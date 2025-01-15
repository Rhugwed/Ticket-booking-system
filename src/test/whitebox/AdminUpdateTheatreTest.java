package test.whitebox;

import org.junit.Test;
import snippet.Admin;
import snippet.TheatreManager;
import snippet.Theatre;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class AdminUpdateTheatreTest {

    @Test
    public void testUpdateTheatre_ValidInputs() {
        TheatreManager theatreManager = new TheatreManager();
        Admin admin = new Admin(theatreManager, null, null);

        // Add a theater
        theatreManager.addTheatre("Downtown", 200);

        // Simulate valid inputs
        ByteArrayInputStream in = new ByteArrayInputStream("1\nCineplex\n300\n".getBytes());
        System.setIn(in);
        admin.resetScanner();

        // Act
        admin.updateTheatre();

        // Assert
        Theatre updatedTheatre = theatreManager.getTheatre(0);
        assertEquals("Cineplex", updatedTheatre.getLocation());
        assertEquals(300, updatedTheatre.getSeatingCapacity());
    }

  

    

    @Test
    public void testUpdateTheatre_InvalidTheatreID() {
        TheatreManager theatreManager = new TheatreManager();
        Admin admin = new Admin(theatreManager, null, null);

        // Simulate invalid theater ID
        ByteArrayInputStream in = new ByteArrayInputStream("99\nCineplex\n300\n".getBytes());
        System.setIn(in);
        admin.resetScanner();

        // Act
        admin.updateTheatre();

        // Assert
        assertEquals(0, theatreManager.getTheatreCount());
    }
}