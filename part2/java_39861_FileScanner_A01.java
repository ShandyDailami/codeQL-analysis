import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_39861_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a File object for the file to be read
        File file = new File("path_to_file");

        try {
            // Create a Scanner object to read the file
            Scanner scanner = new Scanner(file);

            // Use a while loop to read and print out each line of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}