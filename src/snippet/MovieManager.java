package snippet;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private List<Movie> movies;

    // Constructor
    public MovieManager() {
        movies = new ArrayList<>();
    }

    // Add a movie
    public void addMovie(String title, String genre, int duration) {
        if (title == null || title.trim().isEmpty() || genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("Title and Genre cannot be null or empty.");
        }
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be greater than zero.");
        }
        // Check for duplicate movie
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                throw new IllegalArgumentException("Movie already exists.");
            }
        }

        Movie movie = new Movie(title, genre, duration);
        movies.add(movie);
        System.out.println("Movie added: " + movie);
    }
    
    

    // Show all movies
    public void showMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies available.");
        } else {
            System.out.println("Movies List:");
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }
    }

    // Search for a movie by title
    public Movie searchMovie(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }

        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null; // Movie not found
    }

    // Get the number of movies
    public int getMovieCount() {
        return movies.size();
    }

    // Get a specific movie by index
    public Movie getMovie(int index) {
        if (index < 0 || index >= movies.size()) {
            throw new IndexOutOfBoundsException("Invalid index. No such movie exists.");
        }
        return movies.get(index);
    }

    // Clear all movies (optional, useful for tests)
    public void clearMovies() {
        movies.clear();
    }
}