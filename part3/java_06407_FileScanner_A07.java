import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06407_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object for the file to be scanned
        File file = new File("src/main/resources/legacy_file.txt");

        // Create a Scanner object for the file
        Scanner scanner = new Scanner(file);

        // Loop through the file line by line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);

            // Simulate security-sensitive operation related to A07_AuthFailure
            // Here, we are assuming that an AuthFailure exception is thrown when the file contains the word 'auth'
            if (line.toLowerCase().contains("auth")) {
                throw new SecurityException("Authorization failure detected");
            }
        }

        // Close the scanner
        scanner.close();
    }
}