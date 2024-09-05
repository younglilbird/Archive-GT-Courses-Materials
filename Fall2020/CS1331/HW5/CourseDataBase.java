//I worked on the homework assignment alone, using only course materials.
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 *coursedatabase class that contains 4 useful methods.
 *@author Yulong Liang.
 *@version 1.0
 */
public class CourseDataBase {
    /**
     *loader method that return an array of course in a file.
     *@param file the file we need to analyze.
     *@return an array of courses.
     */
    public static ArrayList<Course> loader(File file) {
        ArrayList<Course> arr = new ArrayList<>();
        loadHelper(file, arr);
        return arr;
    }
    /**
     *private method to help build the loader method.
     *@param file the file we need to analyze.
     *@param course an arraylist of courses.
     */
    private static void loadHelper(File file, ArrayList<Course> course) {
        if (file.isDirectory()) {
            File[] filepath = file.listFiles();
            String[] filename = file.list();
            int num = filepath.length;
            for (int i = 0; i < num; i++) {
                File newfile = new File(filepath[i].toString());
                loadHelper(newfile, course);
            }
        } else {
            String path = file.getPath();
            String[] pathname = path.split(File.separator);
            int level = Integer.parseInt(pathname[pathname.length - 2]);
            String major = pathname[pathname.length - 3];
            try {
                Scanner scan = new Scanner(file);
                String available = scan.nextLine();
                String name = file.getName();
                name = name.substring(0, name.length() - 4);
                Course newcourse = new Course(name, level, major, available.equals("AVAILABLE"));
                course.add(newcourse);
            } catch (FileNotFoundException e) {
            }
        }
    }
    /**
     *expect to get the file path for a certain course.
     *@param file the file we need to search through.
     *@param course the certain course we need to search.
     *@return an String array of the path of the course.
     */
    public static String[] getFilePath(File file, Course course) throws CourseNotFoundException, NotAMajorException {
        File[] filepath = file.listFiles();
        for (int i = 0; i < filepath.length; i++) {
            if (filepath[i].getName().equals(course.getMajor())) {
                ArrayList<Course> arr = loader(filepath[i]);
                for (Course co : arr) {
                    if (course.getName().equals(co.getName())) {
                        String[] result = new String[3];
                        result[0] = course.getMajor();
                        result[1] = "" + course.getLevel();
                        result[2] = course.getName() + ".txt";
                        return result;
                    }
                }
                throw new CourseNotFoundException("Course " + course.getName() + " was not found in the database");
            }
        }
        throw new NotAMajorException();
    }
    /**
     *check whether all courses are available.
     *@param file file we need to analyze.
     *@param course an array of courses.
     *@return true iff all courses are available.
     */
    public static boolean scheduleAvailability(File file, Course[] course) {
        boolean result = true;
        boolean checkmajor = false;
        boolean checkname = false;
        ArrayList<Course> clist = loader(file);
        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < clist.size(); j++) {
                checkmajor = checkmajor || (course[i].getMajor().equals(clist.get(j).getMajor()));
                checkname = checkname || (course[i].getName().equals(clist.get(j).getName()));
                if (course[i].getName().equals(clist.get(j).getName())) {
                    result = result && clist.get(j).getAvailability();
                }
            }
            if (!checkmajor) {
                return false;
            }
            if (!checkname) {
                return false;
            }
        }
        return result;
    }
}