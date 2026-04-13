import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22641_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {

        // Define the directory to scan
        File directory = new File("/path/to/directory");

        // Define the pattern to match
        String pattern = "pattern.txt";

        // Initialize a counter
        int count = 0;

        // Use a FileFilter to match the files
        File[] files = directory.listFiles((dir, name) -> name.endsWith(pattern));

        // If there are files that match the pattern, print them out
        if (files != null) {
            for (File file : files) {
                count++;
                System.out.println("Found file: " + file.getName());
            }
        }

        // Print the count
        System.out.println("Number of files found: " + count);
    }
}