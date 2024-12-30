package snippet;

import java.util.ArrayList;
import java.util.List;

public class TheatreManager {
    private List<Theatre> theatres;

    // Constructor
    public TheatreManager() {
        theatres = new ArrayList<>();
    }

    // To add a new theatre
    public void addTheatre(String location, int seatingCapacity) {
        Theatre theatre = new Theatre(location, seatingCapacity);
        theatres.add(theatre);
        System.out.println("Theatre added: " + theatre);
    }

    // to update existing theatre details
    public void updateTheatre(int index, String newLocation, int newSeatingCapacity) {
        if (index < 0 || index >= theatres.size()) {
            throw new IndexOutOfBoundsException("Invalid index. No such theatre exists.");
        }

        Theatre theatre = theatres.get(index);
        theatre.setLocation(newLocation);
        theatre.setSeatingCapacity(newSeatingCapacity);
        System.out.println("Theatre updated: " + theatre);
    }

    //To show all theatres
    public void showAllTheatres() {
        if (theatres.isEmpty()) {
            System.out.println("No theatres available.");
        } else {
            System.out.println("List of theatres:");
            for (int i = 0; i < theatres.size(); i++) {
                System.out.println("Theatre " + (i + 1) + ":");
                theatres.get(i).showTheatres();
            }
        }
    }

    // To Remove a existing theatre 
    public void removeTheatre(int index) {
        if (index < 0 || index >= theatres.size()) {
            throw new IndexOutOfBoundsException("Invalid index. No such theatre exists.");
        }

        Theatre removedTheatre = theatres.remove(index);
        System.out.println("Theatre removed: " + removedTheatre);
    }

    // To find a theatre by location
    public void findTheatreByLocation(String location) {
        boolean found = false;
        for (Theatre theatre : theatres) {
            if (theatre.getLocation().equalsIgnoreCase(location)) {
                System.out.println("Found Theatre: " + theatre);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No theatre found at location: " + location);
        }
    }
}
