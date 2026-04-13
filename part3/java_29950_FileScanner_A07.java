import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_29950_FileScanner_A07 {
    public static void main(String[] args) {
        // Initialize a File object with the file we want to scan
        File file = new File("path/to/file");

        // Initialize a BufferedReader to read the file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // Read each line from the file
            String line;
            while ((line = reader.readLine()) != null) {
                // Print out each line
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle IOExceptions
            System.out.println("An error occurred while reading the file.");
        }
    }
}