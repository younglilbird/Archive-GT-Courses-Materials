//I worked on the homework assignment alone, using only course materials.
/**
 * A freeuser class that extends user abstract class.
 * @author Yulong Liang
 * @version 1.0
 */
public class FreeUser extends User {
    /**
     *a constructor for freeuser with name.
     *@param name of the user.
     */
    public FreeUser(String name) {
        super(name);
    }
    @Override
    public void giveRecommendation(PlayList playlist) {
        Playable[] arr = playlist.getSongs();
        if (arr.length == 0) {
            System.out.println("The playlist is empty");
        } else {
            System.out.println("I recommend the " + arr[0].toString());
        }
    }
}