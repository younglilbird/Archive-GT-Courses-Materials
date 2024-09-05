//I worked on the homework assignment alone, using only course materials.
/**
 * Hiphopsong class that implement the playable interface.
 * @author Yulong Liang
 * @version 1.0
 */
public class HipHopSong implements Playable {
    private String name;
    private String artist;
    private String producer;
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
     *setter for the producer.
     *@param producer producer of the song.
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }
    /**
     *getter for the producer.
     *@return the producer of the song.
     */
    public String getProducer() {
        return this.producer;
    }
    /**
     *a constructor for the hiphopsong class.
     *@param name the song's name
     *@param artist the name of the artist
     *@param producer who produce the song
     */
    public HipHopSong(String name, String artist, String producer) {
        this.name = name;
        this.artist = artist;
        this.producer = producer;
    }
    /**
     *a play method from the interface.
     */
    public void play() {
        System.out.println(this.producer + " on the track! Twitter fingers turn to coding fingers\n");
    }
    @Override
    public String toString() {
        return this.name + " by " + this.artist + " - woo!";
    }
}