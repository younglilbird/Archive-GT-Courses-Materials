//I worked on the homework assignment alone, using only course materials.
/**
 * a classicalsong class implement the playable interface.
 * @author Yulong Liang
 * @version 1.0
 */
public class ClassicalSong implements Playable {
    private String name;
    private String artist;
    private int length;
    /**
     *setter for name.
     *@param name name of the song.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *getter for name.
     *@return the name of the song.
     */
    public String getName() {
        return this.name;
    }
    /**
     *setter for artist.
     *@param artist the artist of the song.
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }
    /**
     *getter for artist.
     *@return the artist of the song.
     */
    public String getArtist() {
        return this.artist;
    }
    /**
     *setter for the length.
     *@param length length of the song.
     */
    public void setLength(int length) {
        this.length = length;
    }
    /**
     *getter for the length.
     *@return the length of the song.
     */
    public int getLength() {
        return this.length;
    }
    /**
     *contruct a classicalsong with name, artist and length.
     *@param name the name of the song.
     *@param artist the artist of the song.
     *@param length how long the song is.
     */
    public ClassicalSong(String name, String artist, int length) {
        this.name = name;
        this.artist = artist;
        this.length = length;
    }
    /**
     *the play method from the playable interface.
     */
    public void play() {
        System.out.println(("weewoo ".repeat(this.length)) + "\n");
    }
    @Override
    public String toString() {
        return this.name + " by " + this.artist + " pub";
    }
}