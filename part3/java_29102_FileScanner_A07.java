import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29102_FileScanner_A07 {

    public static void main(String[] args) {

        // Initialize file
        File file = new File("legacy.txt");

        try {
            // Initialize scanner
            Scanner scanner = new Scanner(file);

            // Continuously read from file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Close scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}