import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class java_35558_FileScanner_A08 {

    public static void main(String[] args) {
        // Setup the target directory
        String targetDirectory = args.length > 0 ? args[0] : System.getProperty("user.dir");

        // Create a filter to find files with a specific extension
        FilenameFilter filter = (dir, name) -> name.endsWith(".txt");

        // Create a scanner that scans the target directory
        File target = new File(targetDirectory);
        File[] files = target.listFiles(filter);

        if (files != null) {
            // Print out the names of all the files in the directory
            Arrays.stream(files).forEach(File::getName);
        } else {
            // The target directory does not exist or is not a directory
            System.out.println("The target directory does not exist or is not a directory.");
        }
    }
}