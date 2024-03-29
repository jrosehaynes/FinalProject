import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MusicApp {
    private static List<Track> tracks = new ArrayList<>();
    private static List<Playlist> playlists = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    // Define a map for genre selection
    private static Map<Integer, String> genres = new HashMap<>();

    static {
        // Initialize genre options
        genres.put(1, "Pop");
        genres.put(2, "Country");
        genres.put(3, "Rock");
        genres.put(4, "Hip Hop");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the MusicApp!");

        boolean addingTracks = true;
        while (addingTracks) {
            System.out.println("\nEnter track details(or type 'done' to fini1sh):");

            System.out.print("Enter track title: ");
            String title = scanner.nextLine();
            if ("done".equalsIgnoreCase(title)) {
                addingTracks = false;
                continue;
            }

            System.out.print("Enter artist name: ");
            String artist = scanner.nextLine();

            // Display genre options and prompt user to select one
            System.out.println("Select genre:");
            for (Map.Entry<Integer, String> genre : genres.entrySet()) {
                System.out.println(genre.getKey() + ". " + genre.getValue());
            }
            System.out.print("Enter the number for the genre: ");
            int genreChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Retrieve the selected genre string from the map
            String genre = genres.get(genreChoice);
            if (genre == null) {
                System.out.println("Invalid genre selection. Please try again.");
                continue;
            }

            Track newTrack = new Track(title, artist, genre);
            tracks.add(newTrack);
            System.out.println("'" + title + "' by " + artist + " added to the track list.");
        }

        int choice;
        do {
            System.out.println("\nMusic App Menu:");
            System.out.println("1. List all tracks");
            System.out.println("2. Display tracks by genre");
            System.out.println("3. Create a playlist");
            System.out.println("4. Display playlists");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    listTracks();
                    break;
                case 2:
                    displayTracksByGenre();
                    break;
                case 3:
                    createPlaylist();
                    break;
                case 4:
                    displayPlaylists();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 0);
    }

    private static void displayTracksByGenre() {
		// TODO Auto-generated method stub
    	System.out.println("Select a genre: ");
        System.out.println("1. Pop");
        System.out.println("2. Country");
        System.out.println("3. Rock");
        System.out.println("4. Hip Hop");
        System.out.print("Enter the number for the genre: ");
        int genreChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String genre = "";
        switch (genreChoice) {
            case 1:
                genre = "Pop";
                break;
            case 2:
                genre = "Country";
                break;
            case 3:
                genre = "Rock";
                break;
            case 4:
                genre = "Hip Hop";
                break;
            default:
                System.out.println("Invalid genre selection.");
                return;
        }

        System.out.println("\nTracks in genre '" + genre + "':");
        for (Track track : tracks) {
            if (track.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(track);
            }
        }
	}

	

	private static void listTracks() {
        System.out.println("\nAvailable Tracks:");
        for (Track track : tracks) {
            System.out.println(track);
        }
    }

    private static void createPlaylist() {
        System.out.print("Enter playlist name: ");
        String name = scanner.nextLine();
        Playlist playlist = new Playlist(name);
        System.out.println("Playlist '" + name + "' created. You can add tracks to it from the main menu.");
    
        /////MAKE WHERE YOU CAN ADD SONGS TO IT
        System.out.println("\nAvailable Tracks:");
        for (int i = 0; i < tracks.size(); i++) {
            System.out.println((i + 1) + ". " + tracks.get(i));
        }

        System.out.println("Enter the numbers of the tracks you want to add to the playlist '" + name + "' (type '0' when finished):");

        int trackNumber;
        do {
            System.out.print("Track number: ");
            trackNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (trackNumber > 0 && trackNumber <= tracks.size()) {
                playlist.addTrack(tracks.get(trackNumber - 1));
            } else if (trackNumber != 0) {
                System.out.println("Invalid track number. Please try again.");
            }
        } while (trackNumber != 0);

        playlist.add(playlist);
        System.out.println("Playlist '" + name + "' created successfully with selected tracks.");
    }
    /////PLAYLIST WONT DISPLAY
    //////
    private static void displayPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("There are no playlists to display.");
            return;
        }

        System.out.println("\nAvailable Playlists:");
        for (Playlist playlist : playlists) {
            System.out.println("Playlist: " + playlist.getName());
            if (playlist.getTracks().isEmpty()) {
                System.out.println("\tThis playlist is currently empty.");
            } else {
                for (Track track : playlist.getTracks()) {
                    System.out.println("\t" + track);
                }
            }
            System.out.println(); // Extra newline for better separation
        }
    }

    }
   
  

