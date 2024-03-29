import java.util.ArrayList;
import java.util.List;

public class Playlist
{
    private String name;
    private List<Track> tracks;

    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
    }
    public void addTrack(Track track) {
        tracks.add(track);
        System.out.println("'" + track.getTitle() + "' by " + track.getArtist() + " added to playlist '" + name + "'.");
    }

    public void removeTrack(String title) {
        boolean found = tracks.removeIf(track -> track.getTitle().equalsIgnoreCase(title));
        if (found) {
            System.out.println("Removed track '" + title + "' from playlist '" + name + "'.");
        } else {
            System.out.println("Track '" + title + "' not found in playlist '" + name + "'.");
        }
    
    }
    public void listTracksByGenre(String genre) {
        System.out.println("\nListing tracks in genre '" + genre + "' from playlist '" + name + "':");
        boolean found = false;
        for (Track track : tracks) {
            if (track.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(track);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tracks found in genre '" + genre + "' in this playlist.");
        }
    }


    public void displayPlaylist() {
        System.out.println("Playlist: " + name);
        for (Track track : tracks) {
            System.out.println(track);
        }
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	public void add(Playlist playlist) {
		// TODO Auto-generated method stub
		
	}
	public List<Track> getTracks() {
		// TODO Auto-generated method stub
		return null;
	}
}