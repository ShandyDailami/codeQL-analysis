import java.io.File;
import java.util.Arrays;

public class java_12311_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a File object for the current directory
        File dir = new File(".");

        // List all files in the directory
        File[] files = dir.listFiles();

        // Check if the directory exists and is not null
        if (files != null) {
            // Print out the list of files
            Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
        } else {
            System.out.println("The directory does not exist!");
        }
    }
}