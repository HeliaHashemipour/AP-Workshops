import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 *
 * @author Helia Sadat Hashemipour
 * @version 2020.10.23
 */
public class MusicCollection {
    // An ArrayList for storing the file names of music files.

    // A player for the music files.
    private final MusicPlayer player;
    private final ArrayList<Music> musics;
    private final ArrayList<Music> favoriteMusics;

    /**
     * Create a MusicCollection
     */
    public MusicCollection() {
        player = new MusicPlayer();
        musics = new ArrayList<Music>();
        favoriteMusics = new ArrayList<Music>();

    }


    /**
     * Add new music.
     *
     * @param music music
     */
    public void addMusic(Music music) {
        musics.add(music);
    }


    /**
     * this method is used to get number of musics.
     *
     * @return musics's size
     */
    public int getNumberOfMusics() {
        return musics.size();
    }

    /**
     * List a music from the collection.
     *
     * @param index The index of the music to be listed.
     */
    public void listMusic(int index) {
        if (validIndex(index)) {
            System.out.println("Address:" + musics.get(index).getAddress() + "   |   Singer name:" + musics.get(index).getName() + "  |   Year of publish:" + musics.get(index).getPublishYear());
        }
    }

    /**
     * Show a list of all the musics in the collection.
     */
    public void listAllMusic() {
        for (Music music : musics) {
            System.out.println("Address:" + music.getAddress() + "   |   Singer name:" + music.getName() + " |   Year of publish:" + music.getPublishYear());
        }
    }

    /**
     * This method is used to add favorite music.
     * @param music music that we want to add to the favorite list
     */
    public void addFavoriteMusic(Music music) {
        int index = favoriteMusics.indexOf(music);
        if (index < 0) {
            favoriteMusics.add(music);
        } else
            System.out.println("This music has been already added to favorite music list!");


    }

    /**
     * This method is used to print favorite musics.
     */
    public void printFavoriteMusicList() {
        for (Music music : favoriteMusics) {
            System.out.println("Favorite Musics:\nAddress:" + music.getAddress() + "   |  Singer name:" + music.getName() + "  |  Year of publish:" + music.getPublishYear() + "\n");
        }

    }

    /**
     * This method is used to search the music
     * @param input  music for input
     */
    public void searchMusic(String input) {
        boolean b = false;
        for (Music music : musics) {
            if (music.getName().equals(input)) {
                System.out.println("Address:" + music.getAddress() + "   |   Singer name:" + music.getName() + "  |   Year of publish:" + music.getPublishYear());
                b = true;
            }
            if (music.getAddress().equals(input)) {
                System.out.println("Address:" + music.getAddress() + "   |   Singer name:" + music.getName() + "   |  Year of publish:" + music.getPublishYear());
                b = true;
            }
            if (!b) {
                System.out.println("This music does not exist");
            }
        }
    }

    /**
     * This method is used to remove the favorite music from favorite musics list.
     * @param music favorite music that we want to remove
     */
    public void removeFavoriteMusic(Music music) {
        int index = favoriteMusics.indexOf(music);
        if (index < 0) {
             System.out.println("This music does not exist in favorite list!");
        } else
           favoriteMusics.remove(music);

    }

    /**
     * Remove a music from the collection.
     *
     * @param index The index of the music to be removed.
     */
    public void removeMusic(int index) {
        if (validIndex(index)) {
            musics.remove(index);
        }
    }

    /**
     * Start playing a music in the collection.
     * Use stopPlaying() to stop it playing.
     *
     * @param index The index of the music to be played.
     */
    public void startPlaying(int index) {
        if (validIndex(index))
            player.startPlaying(musics.get(index).getName());

    }

    /**
     * Stop the player.
     */
    public void stopPlaying() {
        player.stop();
    }


    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     *
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index) {
        // The return value.
        // Set according to whether the index is valid or not.
        if (index >= 0 && index < musics.size()) {
            return true;
        } else {
            System.out.println("Invalid Index!!!");
            return false;
        }

    }
}
