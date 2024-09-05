//I worked on the homework assignment alone, using only course materials.
import java.util.ArrayList;
/**
 * Represents a class with a single method used to.
 * create the ArrayList of Player objects to be used by the game.
 * @author Yulong Liang
 * @version 1.0
 */
public class PlayerLoader {
    class GS3 implements GameStrategy {
        private int counter;
        private GS3() {
            this.counter = 0;
        }
        public void handleEvent(Player player, GameEvent event, Property property) {
            counter++;
            if (counter < 20) {
                if (event == GameEvent.BUY_PROPERTY) {
                    double i = Math.random();
                    if (i < 0.5) {
                        player.buyProperty(property);
                    }
                }
            } else {
                if (event == GameEvent.MANAGE_HOUSES) {
                    if (player.getMoney() < 500) {
                        ArrayList<Property> pless = player.getProperties();
                        int num = pless.size();
                        int j = (int) (Math.random() * num);
                        Property p1 = pless.get(j);
                        p1.changeHouses(-5);
                    } else if (player.getMoney() >= 1000) {
                        ArrayList<Property> pmore = player.getProperties();
                        int num2 = pmore.size();
                        int k = (int) (Math.random() * num2);
                        Property p2 = pmore.get(k);
                        p2.changeHouses(5);
                    }
                }
            }
        }
    }
    /**
     * Initializes the Player list for the Game.
     * @return the List of initialized Player objects
     */
    public ArrayList<Player> loadPlayers() {
        ArrayList<Player> playerList = new ArrayList<>(3);
        GameStrategy gs1 = (Player player, GameEvent event, Property property) -> {
            if (event == GameEvent.BUY_PROPERTY) {
                player.buyProperty(property);
            }
        };
        Player newbie = new Player("Wheelbarrow", gs1);
        playerList.add(0, newbie);
        GameStrategy gs2 = new GameStrategy() {
            public void handleEvent(Player player, GameEvent event, Property property) {
                if (event == GameEvent.BUY_PROPERTY) {
                    if (player.getMoney() >= 500) {
                        player.buyProperty(property);
                    }
                } else if (event == GameEvent.MANAGE_HOUSES) {
                    if (player.getMoney() >= 1000) {
                        ArrayList<Property> pless = player.getProperties();
                        for (int i = pless.size() - 1; i > 0; i--) {
                            if (player.getMoney() >= 500) {
                                pless.get(i).changeHouses(1);
                            }
                        }
                    } else if (player.getMoney() < 500) {
                        ArrayList<Property> pmore = player.getProperties();
                        for (int j = pmore.size() - 1; j > 0; j--) {
                            if (player.getMoney() < 500) {
                                pmore.get(j).changeHouses(-1);
                            }
                        }
                    }
                }
            }
        };
        Player intermediate = new Player("Racecar", gs2);
        playerList.add(1, intermediate);
        GameStrategy gs3 = new GS3();
        Player wildcard = new Player("Thimble", gs3);
        playerList.add(2, wildcard);
        return playerList;
    }
}