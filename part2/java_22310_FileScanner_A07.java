import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22310_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {

        // Define the directory to scan
        String directoryPath = "/path/to/directory";

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (!directory.exists()) {
            System.out.println("The directory does not exist.");
            return;
        }

        // Scan the directory for files
        File[] files = directory.listFiles();

        // Print the names of the files
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}