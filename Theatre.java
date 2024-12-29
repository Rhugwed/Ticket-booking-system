package snippet;

public class Theatre {
    private String location;
    private int seatingCapacity;

    // Constructor
    public Theatre(String location, int seatingCapacity) {
        setLocation(location);
        setSeatingCapacity(seatingCapacity);
    }

    // Getter and Setter for Location
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be null or empty.");
        }
        this.location = location;
    }

    // Getter and Setter for Seating Capacity
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        if (seatingCapacity <= 0) {
            throw new IllegalArgumentException("Seating capacity must be greater than zero.");
        }
        this.seatingCapacity = seatingCapacity;
    }

    // Insert Theatre Details
    public void insertTheater(String location, int seatingCapacity) {
        setLocation(location);
        setSeatingCapacity(seatingCapacity);
        System.out.println("Theater details set: Location = " + this.location + ", Seating Capacity = " + this.seatingCapacity);
    }

    // Placeholder for displaying theater details
    public void showTheaters() {
        System.out.println("Displaying theater details is not implemented yet.");
    }
}
