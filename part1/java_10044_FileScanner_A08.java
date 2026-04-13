import java.io.File;
import java.util.Arrays;

public class java_10044_FileScanner_A08 {
    public static void main(String[] args) {
        // Specify the directory to scan
        File directory = new File("/path/to/your/directory");

        // Get a list of all files in the directory
        File[] files = directory.listFiles();

        // Check if there are any files to scan
        if (files != null) {
            // Print the names of all files
            Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
        } else {
            System.out.println("No files found in the directory");
        }
    }
}