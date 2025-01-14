package snippet;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private List<Movie> movies;

   
    public MovieManager() {
        movies = new ArrayList<>();
    }

 
    public void addMovie(String title, String genre, int duration) {
        if (title == null || title.trim().isEmpty() || genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("Title and Genre cannot be null or empty.");
        }
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be greater than zero.");
        }
       
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                throw new IllegalArgumentException("Movie already exists.");
            }
        }

        Movie movie = new Movie(title, genre, duration);
        movies.add(movie);
        System.out.println("Movie added: " + movie);
    }

  
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

    
    public Movie searchMovie(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }

        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null; 
    }

   
    public int getMovieCount() {
        return movies.size();
    }

    
    public Movie getMovie(int index) {
        if (index < 0 || index >= movies.size()) {
            throw new IndexOutOfBoundsException("Invalid index. No such movie exists.");
        }
        return movies.get(index);
    }

   
    public void clearMovies() {
        movies.clear();
    }

   
    public boolean isValidMovie(int movieID) {
        return movieID > 0 && movieID <= movies.size();
    }

   
    public void updateMovie(int index, String newTitle, String newGenre, int newDuration) {
        if (index < 0 || index >= movies.size()) {
            throw new IndexOutOfBoundsException("Invalid index. No such movie exists.");
        }
        if (newTitle == null || newTitle.trim().isEmpty() || newGenre == null || newGenre.trim().isEmpty()) {
            throw new IllegalArgumentException("New title and genre cannot be null or empty.");
        }
        if (newDuration <= 0) {
            throw new IllegalArgumentException("New duration must be greater than zero.");
        }

        Movie movie = movies.get(index);
        movie.setTitle(newTitle);
        movie.setGenre(newGenre);
        movie.setDuration(newDuration);
        System.out.println("Movie updated: " + movie);
    }
}
