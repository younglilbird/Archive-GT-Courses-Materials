//I worked on the homework assignment alone, using only course materials.
/**
 *course class that contain necessary information.
 *@author Yulong Liang.
 *@version 1.0
 */
public class Course {
    private String name;
    private int level;
    private String major;
    private boolean availability;
    /**
     *setter method for name.
     *@param name the name of course.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *getter method for name.
     *@return the name of course.
     */
    public String getName() {
        return this.name;
    }
    /**
     *setter method for level.
     *@param level the level of course.
     */
    public  void setLevel(int level) {
        if (level == 1000 || level == 2000 || level == 3000 || level == 4000) {
            this.level = level;
        }
    }
    /**
     *getter method for level.
     *@return the level of course.
     */
    public int getLevel() {
        return this.level;
    }
    /**
     *setter method for major.
     *@param major the major of course.
     */
    public void setMajor(String major) {
        this.major = major;
    }
    /**
     *getter method for major.
     *@return the major of course.
     */
    public String getMajor() {
        return this.major;
    }
    /**
     *setter method for availability.
     *@param availability check whether it's available.
     */
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    /**
     *getter method for availability.
     *@return the availability of course.
     */
    public boolean getAvailability() {
        return this.availability;
    }
    /**
     *construct a course with name, level, major and availability.
     *@param name the name of course.
     *@param level the level of course.
     *@param major the major of course.
     *@param availability whether it's available.
     */
    public Course(String name, int level, String major, boolean availability) {
        this.name = name;
        this.level = level;
        this.major = major;
        this.availability = availability;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Course)) {
            return false;
        }
        Course other = (Course) obj;
        boolean result = this.major.equals(other.major) && (this.availability == other.availability);
        return (this.name.equals(other.name) && this.level == other.level && result);
    }
}