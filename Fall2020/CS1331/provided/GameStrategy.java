/**
 * A functional interface representing a strategy a Player would use
 * for the Buying Properties and Managing Houses GameEvents in Monopoly.
 * @author CS 1331 TAs
 * @version 1.0
 */
public interface GameStrategy {
    /**
     * Consists of event-handling code for the passed in
     * Player object.  When invoked, it should perform some
     * action only possible from the perspective of the Player.
     * This action should vary depending on the current state of the game,
     * determined by the event enum.
     * @param player the Player object for which an Event is being handled
     * @param event the current GameEvent that should be handled
     * @param property if the GameEvent is BUY_PROPERTY, is the Property
     * object the Player may or may not purchase.  Otherwise, it is null.
     */
    void handleEvent(Player player, GameEvent event, Property property);
}