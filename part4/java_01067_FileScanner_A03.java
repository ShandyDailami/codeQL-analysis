import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_01067_FileScanner_A03 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("example.txt")); // Open the file

            // Use a while loop to read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); // Read a line
                System.out.println(line); // Print the line
            }

            scanner.close(); // Close the scanner

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage()); // Handle file not found exception
        }
    }
}