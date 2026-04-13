import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12573_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Specify the directory to scan
        String directory = "/path/to/directory";

        // Create a new File object for the directory
        File dir = new File(directory);

        // Check if the directory exists and is a directory
        if (dir.exists() && dir.isDirectory()) {
            // List all the files in the directory
            for (File file : dir.listFiles()) {
                if (file.isFile()) {
                    // Print the file name
                    System.out.println("File: " + file.getName());
                }
            }
        } else {
            System.out.println("Directory not found!");
        }
    }
}