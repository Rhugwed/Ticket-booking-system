package snippet;

public class TheatreManagerTest {
    public static void main(String[] args) {
        TheatreManager manager = new TheatreManager();
        System.out.println("Testing TheatreManager Class:");

        // Add Theatres
        System.out.println("Adding theatres...");
        manager.addTheatre("Downtown", 300);
        manager.addTheatre("Uptown", 200);

        // Show All Theatres
        System.out.println("\nAll theatres:");
        manager.showAllTheatres();

        // Update Theatre
        System.out.println("\nUpdating a theatre...");
        manager.updateTheatre(0, "PVR", 300);

        // Show All Theatres After Update
        System.out.println("\nAll theatres after update:");
        manager.showAllTheatres();

        // Remove Theatre
        System.out.println("\nRemoving a theatre...");
        manager.removeTheatre(1);

        // Show All Theatres After Removal
        System.out.println("\nAll theatres after removal:");
        manager.showAllTheatres();

        // Search for Theatre by Location
        System.out.println("\nSearching for a theatre by location...");
        manager.findTheatreByLocation("PVR");
    }
}
