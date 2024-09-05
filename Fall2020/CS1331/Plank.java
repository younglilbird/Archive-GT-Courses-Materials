//I worked on the homework assignment alone, using only course materials.
/**
 * Represents a Plank object with a given type of wood and 3 pixel components between 0 and 255 (inclusive).
 * @author Yulong Liang
 * @version 1.0
 */
public class Plank implements Comparable<Plank> {
    private final String woodType;
    private final int red, green, blue;


    /**
     * Creates a new Plank object with a given wood type
     * and 3 pixel components to create the color of this Plank,
     * each of which is between 0 and 255, inclusive.
     * @param  woodType the type of wood this Plank is made of
     * @param  red      the red pixel component
     * @param  green    the green pixel component
     * @param  blue     the blue pixel component
     */
    public Plank(String woodType, int red, int green, int blue) {
        this.woodType = woodType;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * Obtains the hue value for the color represented by the red, green, and blue pixel values.
     * @return the hue as described above
     */
    public int getHue() {
        double min = Math.min(Math.min(red, green), blue);
        double max = Math.max(Math.max(red, green), blue);
        if (min == max) {
            return 0;
        }
        double hue = 0;
        if (max == red) {
            hue = (green - blue) / (max - min);
        } else if (max == green) {
            hue = 2.0 + (blue - red) / (max - min);
        } else {
            hue = 4.0 + (red - green) / (max - min);
        }
        hue *= 60;
        if (hue < 0) {
            hue += 360;
        }
        return (int) Math.round(hue);
    }

    /**
     * a method to compare two planks' hues.
     *@param other the other plank variable that need to be compared.
     *@return the number represent the relationship of 2 hues.
     */
    public int compareTo(Plank other) {
        int thisHue = this.getHue();
        int otherHue = other.getHue();
        if (thisHue < otherHue) {
            return -1;
        } else if (thisHue == otherHue) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Plank)) {
            return false;
        }
        Plank other = (Plank) obj;
        boolean result = (this.red == other.red && this.green == other.green && this.blue == other.blue);
        return (this.woodType.equals(other.woodType) && result);
    }
}