import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_26601_FileScanner_A07 {

    public static void main(String[] args) {

        // Create a new File object
        File file = new File("target/file.txt");

        try (Scanner scanner = new Scanner(file)) {
            // Initialize a count
            int count = 0;

            // While there are still lines to read
            while (scanner.hasNextLine()) {
                // Increment the count
                count++;
                // Get the next line
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Print the count
            System.out.println("Number of lines: " + count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}