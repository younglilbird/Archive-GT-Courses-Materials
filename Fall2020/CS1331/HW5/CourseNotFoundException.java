//I worked on the homework assignment alone, using only course materials.
/**
 *checked exception for getfilepath method.
 *@author Yulong Liang.
 *@version 1.0
 */
public class CourseNotFoundException extends Exception {
    /**
     *construct exception with 1 message args.
     *@param message String that initializes the message field.
     */
    public CourseNotFoundException(String message) {
        super(message);
    }
}