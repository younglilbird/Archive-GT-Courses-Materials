//I worked on the homework assignment alone, using only course materials.
/**
 *A representation of a FlyingSuperhero.
 * @author Yulong Liang
 * @version 1.0
 */
public class FlyingSuperhero extends Superhero {
    private boolean flying;
    /**
     *setter method for flying.
     *@param flying whether the superhero can fly
     */
    public void setFlying(boolean flying) {
        this.flying = flying;
    }
    /**
     *getter method for flying.
     *@return whether the superhero can fly.
     */
    public boolean getFlying() {
        return this.flying;
    }
    /**
     *construct a flyingsuperhero with name health, damage and flying.
     *@param name of the superhero.
     *@param health of the superhero.
     *@param damage of the superhero.
     *@param flying of the superhero.
     */
    public FlyingSuperhero(String name, int health, int damage, boolean flying) {
        super(name, health, damage);
        this.flying = flying;
    }
    /**
     *construct a flyingsuperhero with default value of captain marvel, 40, 7 and false.
     */
    public FlyingSuperhero() {
        this("Captain Marvel", 40, 7, false);
    }
    @Override
    public String toString() {
        return super.toString() + "\nFlying: " + this.flying;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof FlyingSuperhero)) {
            return false;
        }
        FlyingSuperhero other = (FlyingSuperhero) obj;
        return super.equals(obj) && this.flying == other.flying;
    }
    /**
     *show how a flying or not flying superhero can attack others.
     *@param other the superhero been attacked.
     */
    public void attack(Superhero other) {
        double i = Math.random();
        int thishealth = this.getHealth();
        int thisdamage = this.getDamage();
        int otherdamage = other.getDamage();
        int otherhealth = other.getHealth();
        if (thishealth > 0) {
            if (this.flying) {
                if (i < 0.5) {
                    otherhealth = otherhealth - (3 * thisdamage);
                    if (otherhealth < 0) {
                        other.setHealth(0);
                    } else {
                        other.setHealth(otherhealth);
                    }
                } else {
                    otherhealth = otherhealth - thisdamage;
                    if (otherhealth < 0) {
                        other.setHealth(0);
                    } else {
                        other.setHealth(otherhealth);
                    }
                }
            } else {
                otherhealth = otherhealth - thisdamage;
                if (otherhealth < 0) {
                    other.setHealth(0);
                } else {
                    other.setHealth(otherhealth);
                }
            }
        }
    }
}