import java.io.File;
import java.util.Arrays;

public class java_39524_FileScanner_A03 {
    public static void main(String[] args) {
        // Define the directory to scan
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        // Scan the directory
        File[] files = directory.listFiles();

        // Check if there are files in the directory
        if (files != null) {
            // Print the names of all files
            Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
        } else {
            System.out.println("No files found in the directory.");
        }
    }
}