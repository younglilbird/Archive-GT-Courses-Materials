//I worked on the homework assignment alone, using only course materials.
/**
 * A playlist for user to run.
 * @author Yulong Liang
 * @version 1.0
 */
public class PlayList {
    private Playable[] songs;
    private String name;
    private int currentlyPlaying;
    private User owner;
    /**
     *setter for songs.
     *@param songs an array with songs.
     */
    public void setSongs(Playable[] songs) {
        this.songs = songs;
    }
    /**
     *getter for songs.
     *@return an array for songs.
     */
    public Playable[] getSongs() {
        return this.songs;
    }
    /**
     *setter for name.
     @param name the name of songs.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *getter for name.
     *@return the name of the playlist.
     */
    public String getName() {
        return this.name;
    }
    /**
     *setter method for currentlyplaying.
     *@param currentlyPlaying the song that is playing.
     */
    public void setCurrentlyPlaying(int currentlyPlaying) {
        this.currentlyPlaying = currentlyPlaying;
    }
    /**
     *getter method for currentlyPlaying.
     *@return the index of the song that is playing.
     */
    public int getCurrentlyPlaying() {
        return this.currentlyPlaying;
    }
    /**
     *setter method for owner.
     *@param owner the user of the playlist.
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }
    /**
     *getter method for owner.
     *@return the owner of the playlist.
     */
    public User getOwner() {
        return this.owner;
    }
    /**
     * construct the playlist with songs, name and owner.
     *@param songs an array with songs.
     *@param name the name of the playlist.
     *@param owner the user that owns the playlist.
     */
    public PlayList(Playable[] songs, String name, User owner) {
        this.songs = songs;
        this.name = name;
        this.owner = owner;
        this.currentlyPlaying = -1;
    }
    @Override
    public String toString() {
        if (currentlyPlaying == -1) {
            return this.name + "owned by " + this.owner.toString() + ", currently playing nothing";
        } else {
            String result = this.name + " owned by " + this.owner.toString() + ", currently playing ";
            return result + songs[currentlyPlaying].toString();
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof PlayList)) {
            return false;
        }
        PlayList other = (PlayList) obj;
        boolean b1 = this.owner.equals(other.owner);
        return this.name.equals(other.name) && b1;
    }
    @Override
    public int hashCode() {
        return this.name.hashCode() + this.owner.hashCode();
    }
    /**
     *a menthod to run the playlist at certain way.
     */
    public void startPlaying() {
        if (currentlyPlaying < 0 || currentlyPlaying > songs.length - 1) {
            for (int i = 0; i < songs.length; i++) {
                songs[i].play();
            }
        } else {
            for (int i = currentlyPlaying; i < songs.length; i++) {
                songs[i].play();
            }
        }
        currentlyPlaying = -1;
    }
}