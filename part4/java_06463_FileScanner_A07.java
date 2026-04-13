import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06463_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a File object using the constructor
        File file = new File("path_to_your_file.txt");

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

        // Check if the file can be read
        if (!file.canRead()) {
            System.out.println("File is not readable");
            return;
        }

        // Create a Scanner object for the file
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}