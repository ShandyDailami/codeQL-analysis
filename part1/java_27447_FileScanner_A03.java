import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_27447_FileScanner_A03 {
    public static void main(String[] args) {
        // Creating a new File object to represent the legacy file
        File legacyFile = new File("legacyFile.txt");

        // Checking if the file exists
        if (legacyFile.exists()) {
            // Trying to open the file for reading
            try (Scanner fileScanner = new Scanner(legacyFile)) {
                // Reads the file line by line
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("The file does not exist.");
            }
        } else {
            System.out.println("The file does not exist.");
        }
    }
}