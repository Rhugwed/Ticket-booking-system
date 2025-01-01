package snippet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TheatreTest {
    @Test
    void testValidTheatreCreation() {
        Theatre theatre = new Theatre("Downtown", 200);
        assertEquals("Downtown", theatre.getLocation());
        assertEquals(200, theatre.getSeatingCapacity());
    }

    @Test
    void testInvalidTheatreCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Theatre("", -10);
        });
    }

    @Test
    void testDisplayTheatre() {
        Theatre theatre = new Theatre("Downtown", 200);
        assertEquals("Location: Downtown, Seating Capacity: 200", theatre.toString());
    }
}





