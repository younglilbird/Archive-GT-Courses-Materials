import java.util.ArrayList;
/**
 * Represents a Monopoly Game, with some very large
 * static methods.
 * @author CS 1331 TAs
 * @version 1.0
 */
public class Monopoly {

    private static final Property[] PROPERTIES = {
        new Property("Mediterranean Avenue", 2, 60),
        new Property("Baltic Avenue", 4, 60),
        new Property("Oriental Avenue", 6, 100),
        new Property("Vermont Avenue", 6, 100),
        new Property("Connecticut Avenue", 8, 120),
        new Property("St. Charles Place", 10, 140),
        new Property("States Avenue", 10, 140),
        new Property("Virginia Avenue", 12, 160),
        new Property("St. James Place", 14, 180),
        new Property("Tennessee Avenue", 14, 180),
        new Property("New York Avenue", 16, 200),
        new Property("Kentucky Avenue", 18, 220),
        new Property("Indiana Avenue", 18, 220),
        new Property("Illinois Avenue", 20, 240),
        new Property("Atlantic Avenue", 22, 260),
        new Property("Ventnor Avenue", 22, 260),
        new Property("Marvin Gardens", 24, 280),
        new Property("Pacific Avenue", 26, 300),
        new Property("North Carolina Avenue", 26, 300),
        new Property("Pennsylvania Avenue", 28, 320),
        new Property("Park Place", 35, 350),
        new Property("Boardwalk", 50, 400)
    };
    private static ArrayList<Player> playerList = new ArrayList<>();;
    private static int playerTurn = 0;
    /**
     * Entry point for the program.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        playerList = new PlayerLoader().loadPlayers();
        play();
    }

    /**
     * Runs the Monopoly Game to completion, ending only once all but 1
     * Players are bankrupt.
     */
    public static void play() {
        while (playerList.stream().filter(Player::stillPlaying).count() > 1) {
            Player currentPlayer = playerList.get(playerTurn);
            if (currentPlayer.stillPlaying()) {
                if (currentPlayer.jailTurnCounter == 0) {
                    currentPlayer.jailTurnCounter = 0;
                    int die1 = (int) (Math.random() * 6) + 1;
                    int die2 = (int) (Math.random() * 6) + 1;
                    if (die1 == die2) {
                        currentPlayer.jailTurnCounter = 1;
                        System.out.println(currentPlayer + " just went to jail for rolling doubles!");
                    } else {
                        int oldLoc = currentPlayer.currentIndex;
                        int newLoc = (oldLoc + die1 + die2) % PROPERTIES.length;
                        currentPlayer.currentIndex = newLoc;
                        Property prop = PROPERTIES[newLoc];
                        System.out.println(currentPlayer + " landed on " + prop);
                        if (prop.getOwner() == null) {
                            currentPlayer.handleEvent(GameEvent.BUY_PROPERTY, prop);
                        } else if (!prop.getOwner().equals(currentPlayer)) {
                            currentPlayer.payRent(prop);
                        }
                    }
                } else {
                    String prefix;
                    switch (currentPlayer.jailTurnCounter) {
                    case 1:
                        prefix = "st";
                        break;
                    case 2:
                        prefix = "nd";
                        break;
                    default:
                        prefix = "rd";
                    }
                    System.out.println(
                        currentPlayer + " is spending their " + currentPlayer.jailTurnCounter
                        + prefix + " turn in jail"
                    );
                    currentPlayer.jailTurnCounter++;
                    if (currentPlayer.jailTurnCounter == 4) {
                        currentPlayer.jailTurnCounter = 0;
                        currentPlayer.changeMoney(-50);
                        System.out.println(
                            currentPlayer + " just paid $50 to get out of jail"
                        );
                    }
                }
                currentPlayer.handleEvent(GameEvent.MANAGE_HOUSES, null);
                currentPlayer.vibeCheck();
            }
            playerTurn = (playerTurn + 1) % playerList.size();
        }
        System.out.println("Game Over!");
    }

}