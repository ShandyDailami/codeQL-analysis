import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_15962_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a FileReader to read the file
        try (FileReader reader = new FileReader("path_to_your_file")) {
            // Create a BufferedReader to read the file line by line
            try (BufferedReader bufferedReader = new BufferedReader(reader)) {
                // Read the file line by line
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    // Print out the line
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}