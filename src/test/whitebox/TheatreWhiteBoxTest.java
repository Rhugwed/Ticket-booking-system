package test.whitebox;

import org.junit.Test;
import snippet.Theatre;

import static org.junit.Assert.*;

public class TheatreWhiteBoxTest {

    @Test
    public void testInsertTheatre_ValidInputs() {
        // Arrange
        Theatre theatre = new Theatre("Downtown", 300);

        // Act
        theatre.insertTheatre("Uptown", 500);

        // Assert
        assertEquals("Uptown", theatre.getLocation());
        assertEquals(500, theatre.getSeatingCapacity());
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