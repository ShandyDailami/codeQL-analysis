import java.io.File;
import java.util.Arrays;

public class java_32516_FileScanner_A08 {
    public static void main(String[] args) {
        // Set the directory path
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        // List all files in the directory
        File[] files = directory.listFiles();

        // Check if there are any files in the directory
        if (files != null) {
            // Print all file names
            Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
        } else {
            // Handle the case when there are no files in the directory
            System.out.println("No files found in the directory.");
        }
    }
}