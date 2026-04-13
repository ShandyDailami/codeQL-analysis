import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20143_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            // Use a file that doesn't exist in the current directory.
            Scanner fileScanner = new Scanner(new File("doesNotExist.txt"));

            // Read the file line by line.
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

            // Close the scanner.
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}