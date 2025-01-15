package test.blackbox;

import org.junit.Test;
import snippet.Admin;
import snippet.TheatreManager;
import snippet.Theatre;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class AdminBlackBoxTheatreTest {

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

        // Assert (outputs are observed from the perspective of a user)
        Theatre updatedTheatre = theatreManager.getTheatre(0);
        assertEquals("Cineplex", updatedTheatre.getLocation());
        assertEquals(300, updatedTheatre.getSeatingCapacity());
    }

    @Test
    public void testUpdateTheatre_EmptyLocation() {
        TheatreManager theatreManager = new TheatreManager();
        Admin admin = new Admin(theatreManager, null, null);

        // Add a theater
        theatreManager.addTheatre("Downtown", 200);

        // Simulate empty location
        ByteArrayInputStream in = new ByteArrayInputStream("1\n\n300\n".getBytes());
        System.setIn(in);
        admin.resetScanner();

        // Act
        admin.updateTheatre();

        // Assert
        // Verify that the location wasn't updated
        Theatre unchangedTheatre = theatreManager.getTheatre(0);
        assertEquals("Downtown", unchangedTheatre.getLocation());
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
        // Verify no theaters were updated or modified
        assertEquals(0, theatreManager.getTheatreCount());
    }
}