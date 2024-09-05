/**
 * Represents a Monopoly property.
 * @author CS 1331 TAs
 * @version 1.0
 */
public class Property {
    private final String name;
    private final int rentCost;
    private final int propertyCost;
    private int numHouses;
    private Player owner;

    /**
     * Creates a new Monopoly property with the corresponding
     * passed in instance variables.
     * @param  name         the name of this property
     * @param  rentCost     the base cost of rent when this property is
     * un-mortgaged and does not have any houses
     * @param  propertyCost the amount this property costs to purchase
     */
    public Property(String name, int rentCost, int propertyCost) {
        this.name = name;
        this.rentCost = rentCost;
        this.propertyCost = propertyCost;
        this.numHouses = 0;
        this.owner = null;
    }

    /**
     * If this property does not have an owner, sets it to newOwner.
     * @param newOwner the potential new property owner
     */
    public void setOwner(Player newOwner) {
        if (owner == null) {
            owner = newOwner;
        }
    }

    /**
     * Changes the number of houses by the passed in amount.
     * Caps the positive change up to 5 houses and negative
     * change to 0 houses.  Make the passed in value negative
     * if you wish to remove houses from this property.
     * @param change the amount of houses to add/subtract
     */
    public void changeHouses(int change) {
        if (numHouses + change < 0) {
            change = -numHouses;
        } else if (numHouses + change > 5) {
            change = 5 - numHouses;
        }
        if (change != 0) {
            if (change < 0) {
                owner.changeMoney(Math.abs(change) * propertyCost / 4);
                System.out.println(owner + " just sold " + Math.abs(change) + " houses on " + this);
            } else {
                owner.changeMoney(-change * propertyCost / 2);
                System.out.println(owner + " just bought " + Math.abs(change) + " houses on " + this);
            }
            numHouses += change;
        }
    }

    /**
     * The effective rent paid on this property, taking into account
     * the number of houses.
     * @return the rent as described above
     */
    public int getEffectiveRent() {
        return rentCost * (numHouses + 1);
    }

    /**
     * Getter for propertyCost.
     * @return propertyCost
     */
    public int getCost() {
        return propertyCost;
    }

    /**
     * Getter for propertyCost.
     * @return propertyCost
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * Resets this Property if the passed in Player is inactive.
     * @param player Player object to check for inactivity
     */
    public void reset(Player player) {
        if (!player.stillPlaying()) {
            owner = null;
            numHouses = 0;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Property)) {
            return false;
        }
        Property otherProp = (Property) other;
        return otherProp.name.equals(name);
    }

    @Override
    public String toString() {
        return String.format("Property %s with %d houses", name, numHouses);
    }
}