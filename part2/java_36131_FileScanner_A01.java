import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_36131_FileScanner_A01 {

    public static void main(String[] args) {

        // Create a File object for the current directory's access.txt file
        File file = new File("access.txt");

        try {
            // Create a Scanner to read the file
            Scanner scanner = new Scanner(file);

            // Continuously read and print the file's contents
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