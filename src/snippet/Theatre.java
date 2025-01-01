package snippet;

public class Theatre {
    private String location;
    private int seatingCapacity;

    // Constructor
    public Theatre(String location, int seatingCapacity) {
        setLocation(location);
        setSeatingCapacity(seatingCapacity);
    }
    //  getter and setter for seating capacity
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        if (seatingCapacity <= 0) {
            throw new IllegalArgumentException("Seating capacity must be more than zero.");
        }
        this.seatingCapacity = seatingCapacity;
    }

    // Location's getter and setter
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("The location cannot be empty or null.");
        }
        this.location = location;
    }

    

    // Insert Details of Theatre
    public void insertTheatre(String location, int seatingCapacity) {
        setLocation(location);
        setSeatingCapacity(seatingCapacity);
        System.out.println("Theatre details set: Location = " + this.location + ", Seating Capacity = " + this.seatingCapacity);
    }

    //A placeholder for the theatre's details
    public void showTheatres() {
        System.out.println(" Location:" + location);
        System.out.println(" Seating Capacity:" + seatingCapacity);
    }
 // toString method for displaying theatre details
    @Override
    public String toString() {
        return "Location: " + location + ", Seating Capacity: " + seatingCapacity;
    }
}

