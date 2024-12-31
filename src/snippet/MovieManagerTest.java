package snippet;

public class MovieManagerTest {
    public static void main(String[] args) {
        // Create an instance of MovieManager
        MovieManager movieManager = new MovieManager();

        // Test case 1: Add movies
        System.out.println("Test Case 1: Add Movies");
        try {
            movieManager.addMovie("Inception", "Sci-Fi", 148);
            movieManager.addMovie("The Godfather", "Crime", 175);
            movieManager.addMovie("The Dark Knight", "Action", 152);
            System.out.println("Movies added successfully.\n");
        } catch (Exception e) {
            System.out.println("Failed to add movie: " + e.getMessage());
        }

        // Test case 2: Display all movies
        System.out.println("Test Case 2: Show All Movies");
        movieManager.showMovies();
        System.out.println();

        // Test case 3: Search for an existing movie
        System.out.println("Test Case 3: Search for an Existing Movie");
        Movie foundMovie = movieManager.searchMovie("Inception");
        if (foundMovie != null) {
            System.out.println("Movie found: " + foundMovie + "\n");
        } else {
            System.out.println("Movie not found.\n");
        }

        // Test case 4: Search for a non-existing movie
        System.out.println("Test Case 4: Search for a Non-Existing Movie");
        Movie notFoundMovie = movieManager.searchMovie("Avatar");
        if (notFoundMovie != null) {
            System.out.println("Movie found: " + notFoundMovie + "\n");
        } else {
            System.out.println("Movie not found.\n");
        }

        // Test case 5: Add a movie with invalid inputs
        System.out.println("Test Case 5: Add Movie with Invalid Inputs");
        try {
            movieManager.addMovie("", "Comedy", 120); // Invalid title
        } catch (Exception e) {
            System.out.println("Failed to add movie: " + e.getMessage());
        }

        try {
            movieManager.addMovie("Interstellar", "", 169); // Invalid genre
        } catch (Exception e) {
            System.out.println("Failed to add movie: " + e.getMessage());
        }

        try {
            movieManager.addMovie("Interstellar", "Sci-Fi", -10); // Invalid duration
        } catch (Exception e) {
            System.out.println("Failed to add movie: " + e.getMessage());
        }

        System.out.println("\nFinal Movie List:");
        movieManager.showMovies();
    }
}
