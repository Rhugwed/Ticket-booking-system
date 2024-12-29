package snippet;

public class TheatreTest {
    public static void main(String[] args) {
        // Create a Theatre object
        Theatre theatre = new Theatre("Grand Theatre", 200);

        // Display initial details
        System.out.println("Location: " + theatre.getLocation());
        System.out.println("Seating Capacity: " + theatre.getSeatingCapacity());

        // Update theatre details
        theatre.insertTheatre("City Center", 300);

        // Placeholder for showTheaters
        theatre.showTheatres();
    }
}

