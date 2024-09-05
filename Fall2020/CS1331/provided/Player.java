import java.util.ArrayList;
/**
 * Represents a Monopoly Player.
 * @author CS 1331 TAs
 * @version 1.0
 */
public class Player {
    private final ArrayList<Property> ownedProperties;
    private final GameStrategy strategy;
    private final String token;
    private int money;
    public int currentIndex;
    public int jailTurnCounter;
    private boolean playing;

    /**
     * Creates a new Monopoly Player with the corresponding instance variables
     * and $1500.
     * @param  token    the String token this Player uses on the board
     * @param  strategy [description]
     */
    public Player(String token, GameStrategy strategy) {
        this.ownedProperties = new ArrayList<>();
        this.strategy = strategy;
        this.token = token;
        this.money = 1500;
        this.currentIndex = 0;
        this.jailTurnCounter = 0;
        this.playing = true;
    }

    /**
     * Invokes the handleEvent on this Player's strategy.
     * @param event    the enum GameEvent which occurred
     * @param property the Property object in question if event is BUY_PROPERTY
     */
    public void handleEvent(GameEvent event, Property property) {
        strategy.handleEvent(this, event, property);
    }


    /**
     * If this player can afford it, purchases the passed in Property.
     * @param property the Property to buy
     */
    public void buyProperty(Property property) {
        if (playing && property.getOwner() == null) {
            if (money >= property.getCost()) {
                property.setOwner(this);
                money -= property.getCost();
                ownedProperties.add(property);
                System.out.println(this + " just bought " + property);
            } else {
                System.out.println(this + " could not afford " + property);
            }
        }
    }

    /**
     * Unconditionally pays rent to the owner of the passed in Property.
     * @param property the Property we do not own and must pay rent on
     */
    public void payRent(Property property) {
        System.out.println(
            this + " just paid " + property.getEffectiveRent()
            + " to " + property.getOwner() + " on " + property
        );
        property.getOwner().money += property.getEffectiveRent();
        money -= property.getEffectiveRent();
    }

    /**
     * Changes money by the passed in amount.
     * @param amount The amount to change money by
     */
    public void changeMoney(int amount) {
        money += amount;
    }

    /**
     * Checks whether this Player should be eliminated, and if so
     * eliminates them, freeing up all their Properties.
     */
    public void vibeCheck() {
        if (money <= 0) {
            playing = false;
            for (Property p: ownedProperties) {
                p.reset(this);
            }
            ownedProperties.clear();
            System.out.println(this + " has gone bankrupt!");
        }
    }

    /**
     * Getter for properties.
     * @return ownedProperties
     */
    public ArrayList<Property> getProperties() {
        return ownedProperties;
    }

    /**
     * Getter for playing.
     * @return playing
     */
    public boolean stillPlaying() {
        return playing;
    }

    /**
     * Getter for money.
     * @return money
     */
    public int getMoney() {
        return money;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Player)) {
            return false;
        }
        Player otherP = (Player) other;
        return token.equals(otherP.token);
    }

    @Override
    public String toString() {
        return String.format("Player %s with $%d", token, money);
    }
}
