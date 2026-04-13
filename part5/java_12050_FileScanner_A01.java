import java.io.File;
import java.util.Arrays;

public class java_12050_FileScanner_A01 {
    public static void main(String[] args) {
        // Specify the directory you want to scan
        String directoryPath = "/path/to/directory";

        // Get all files in the directory
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        // Check if there are any files
        if (files != null) {
            // Print the list of files
            Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
        } else {
            System.out.println("No files found in the directory.");
        }
    }
}