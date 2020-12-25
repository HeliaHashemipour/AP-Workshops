/**
 * This program is the simple music library.
 * It can add music,play or stop music,have favorite music and remove music
 * from the list of musics or favorite musics.
 *
 * @author Helia Sadat Hashemipour
 * @version 2020.10.23
 */

public class Main {

    public static void main(String[] args) {
        MusicCollection pop = new MusicCollection();
        MusicCollection jazz = new MusicCollection();
        MusicCollection rock = new MusicCollection();
        MusicCollection country = new MusicCollection();
        Music music1 = new Music("C://music", "Pink Floyd", "2009");
        Music music2 = new Music("D://music", "Luke Bryn", "2019");
        Music music3 = new Music("C://music", "Miles Davis", "1980");
        Music music4 = new Music("C://music", "Linkin Park", "2003");
        Music music5 = new Music("C://music", "Katy Perry", "2020");
        pop.addMusic(music5);
        jazz.addMusic(music3);
        rock.addMusic(music4);
        country.addMusic(music2);
        rock.addMusic(music1);
        System.out.println("Rock musics number: " + rock.getNumberOfMusics());
        rock.removeMusic(1);
        System.out.println("Rock musics number(After removing): " + rock.getNumberOfMusics());
        jazz.listMusic(0);
        pop.addFavoriteMusic(music5);
        country.addFavoriteMusic(music2);
        pop.printFavoriteMusicList();
        country.printFavoriteMusicList();
        country.removeFavoriteMusic(music2);
        pop.listAllMusic();
        country.searchMusic("Luke Bryn");
        country.searchMusic("Selena Gomez");
        rock.startPlaying(0);
        pop.stopPlaying();


    }
}
