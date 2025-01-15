package test.whitebox;

import org.junit.Test;
import snippet.Admin;
import snippet.TheatreManager;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class AdminWhiteBoxTest {

    @Test
    public void testViewTheatres_NoTheatres() {
        // Arrange
        TheatreManager theatreManager = new TheatreManager();
        Admin admin = new Admin(theatreManager, null, null);

        // Redirect console output to verify behavior
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        admin.viewTheatres();

        // Assert
        String actualOutput = out.toString().trim();
        assertEquals("No theatres available.", actualOutput);
    }
}