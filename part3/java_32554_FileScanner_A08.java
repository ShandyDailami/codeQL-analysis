import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32554_FileScanner_A08 {

    public static void main(String[] args) {
        try {
            // Create a Scanner to read the input file
            Scanner scanner = new Scanner(new File("input.txt"));

            // Infinite loop to read and print the file contents
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Close the scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found.");
        }
    }
}