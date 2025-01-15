package snippet;

public class Movie {
    private String title;
    private String genre;
    private int duration; // in minutes

    // Constructor
    public Movie(String title, String genre, int duration) {
        setTitle(title);
        setGenre(genre);
        setDuration(duration);
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if (genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be null or empty.");
        }
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be greater than zero.");
        }
        this.duration = duration;
    }

    // Overriding toString
    @Override
    public String toString() {
        return "Title: " + title + ", Genre: " + genre + ", Duration: " + duration + " minutes";
    }
}