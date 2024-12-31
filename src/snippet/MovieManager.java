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
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null; // Movie not found
    }
}

