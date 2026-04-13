import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16043_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a File object for the file to be scanned
        File file = new File("src/main/resources/authFailureData.txt");

        // Create a Scanner object for the file
        try {
            Scanner scanner = new Scanner(file);

            // Loop through each line in the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Check if the line is an authentication failure
                if (line.equals("A07_AuthFailure")) {
                    System.out.println("Authentication failure detected: " + line);
                }
            }

            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}