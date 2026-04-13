import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03322_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new File object for the file to be read
        File file = new File("src/main/resources/A01_BrokenAccessControl.txt");

        // Use a Scanner to read the file
        Scanner scanner = new Scanner(file);

        // Iterate over the lines in the file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        // Close the scanner
        scanner.close();
    }
}