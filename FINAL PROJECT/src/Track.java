
public class Track {
    private String title;
    private String artist;
    private String genre;

    public Track(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist + ", Genre: " + genre;
    }
}
