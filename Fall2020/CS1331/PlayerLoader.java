//I worked on the homework assignment alone, using only course materials.
import java.util.ArrayList;
/**
 * Represents a class with a single method used to.
 * create the ArrayList of Player objects to be used by the game.
 * @author Yulong Liang
 * @version 1.0
 */
public class PlayerLoader {
    /**
     * Initializes the Player list for the Game.
     * @return the List of initialized Player objects
     */
    public ArrayList<Player> loadPlayers() {
        ArrayList<Player> playerList = new ArrayList<>();
        GameStrategy gs1 = handleEvent((Player player, GameEvent event, Property property) -> {
        	if (event.equals(BUY_PROPERTY)) {
        		player.buyProperty(property);
        	}
        });
        Player newbie = new Player("Wheelbarrow", gs1);
        playerList.set(newbie);
        return playerList;
    }
}