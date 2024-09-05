//I worked on the homework assignment alone, using only course materials.
/**
 *A representation of a ChargedSuperhero.
 * @author Yulong Liang
 * @version 1.0
 */
public class ChargedSuperhero extends Superhero {
    private boolean charged;
    /**
     *setter method for charged.
     *@param charged whether the superhero is charged.
     */
    public void setCharged(boolean charged) {
        this.charged = charged;
    }
    /**
     *getter method for charged.
     *@return whether the superhero is charged.
     */
    public boolean getCharged() {
        return this.charged;
    }
    /**
     *construct a chargedsuperhero with name, health, damage and chagred.
     *@param name the name of superhero.
     *@param health the health value of superhero.
     *@param damage the damage value of superhero.
     *@param charged whether the suit is charged.
     */
    public ChargedSuperhero(String name, int health, int damage, boolean charged) {
        super(name, health, damage);
        this.charged = charged;
    }
    /**
     *construct a chargedsuperhero with default value black panther, 30, 10 and false.
     */
    public ChargedSuperhero() {
        this("Black Panther", 30, 10, false);
    }
    @Override
    public String toString() {
        return  super.toString() + "\nSuit Charged: " + this.charged;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ChargedSuperhero)) {
            return false;
        }
        ChargedSuperhero other = (ChargedSuperhero) obj;
        return super.equals(obj) && this.charged == other.charged;
    }
    /**
     *show how a charged or not charged superhero attack others.
     *@param other the superhero been attacked.
     */
    public void attack(Superhero other) {
        int thishealth = this.getHealth();
        int thisdamage = this.getDamage();
        int otherdamage = other.getDamage();
        int otherhealth = other.getHealth();
        if (thishealth > 0) {
            if (this.charged) {
                if (otherhealth - (2 * thisdamage) < 0) {
                    other.setHealth(0);
                } else {
                    otherhealth = otherhealth - (2 * thisdamage);
                    other.setHealth(otherhealth);
                }
            } else {
                if (otherhealth - thisdamage < 0) {
                    other.setHealth(0);
                } else {
                    otherhealth = otherhealth - thisdamage;
                    other.setHealth(otherhealth);
                }
            }
        }
    }
}