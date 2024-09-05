//I worked on the homework assignment alone, using only course materials.
import java.util.ArrayList;
/**
 * Represents a Pirate object with a given name.
 * @author Yulong Liang
 * @version 1.0
 */
public class Pirate {
    private String name;
    /**
     *setter for name.
     *@param name the name of the pirate.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *getter for name.
     *@return the name of the pirate.
     */
    public String getName() {
        return this.name;
    }
    /**
     *construct a pirate with name.
     *@param name the name of the pirate.
     */
    public Pirate(String name) {
        this.name = name;
    }
    /**
     *method to sort the plank object.
     *@param planks an arraylist of plank object.
     */
    public void createBridge(ArrayList<Plank> planks) {
        int length = planks.size();
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (planks.get(j).compareTo(planks.get(j - 1)) < 0) {
                    Plank key = planks.get(j);
                    planks.set(j, planks.get(j - 1));
                    planks.set(j - 1, key);
                }
            }
        }
    }
    /**
     *method to find certain plank object.
     *@param plankToFind the certain plank we need to find.
     *@param planks an arraylist of plank object.
     *@return whether we can find such plank.
     */
    public Plank completeBridge(Plank plankToFind, ArrayList<Plank> planks) {
        for (int i = 0; i < planks.size(); i++) {
            Plank result = planks.get(i);
            if (result.equals(plankToFind)) {
                return result;
            }
        }
        return null;
    }
}