import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08654_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // This file will not be accessible due to security constraints.
        File file = new File("src/main/resources/BrokenAccessControl.java");

        // Create a Scanner object to read the file.
        Scanner scanner = new Scanner(file);

        // Print out all lines in the file.
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        // Close the scanner.
        scanner.close();
    }
}