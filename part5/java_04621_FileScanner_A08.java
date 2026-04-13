import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_04621_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a File object for the file to be read
        File file = new File("path/to/file.txt");

        try {
            // Create a Scanner object for the file
            Scanner scanner = new Scanner(file);

            // Use a while loop to read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Close the Scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}