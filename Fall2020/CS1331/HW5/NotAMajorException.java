//I worked on the homework assignment alone, using only course materials.
/**
 *unchecked exception for getfilepath method.
 *@author Yulong Liang.
 *@version 1.0
 */
public class NotAMajorException extends RuntimeException {
    /**
     *constructor for exception with no-args.
     */
    public NotAMajorException() {
        super("That is not a major we know!");
    }
}