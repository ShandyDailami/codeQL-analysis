import java.io.File;
import java.util.Scanner;

public class java_35330_FileScanner_A08 {
    public static void main(String[] args) {
        // Try to get the current directory
        File file = new File(".");

        try {
            // Create a new scanner for the file
            Scanner scanner = new Scanner(file);

            // Use a while loop to read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Close the scanner
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred while trying to read the file.");
        }
    }
}