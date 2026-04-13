import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39107_FileScanner_A07 {

    public static void main(String[] args) {
        try {
            // Create a File object for the file we want to scan
            File file = new File("src/main/resources/authfailure.txt");

            // Create a Scanner object for the file
            Scanner scanner = new Scanner(file);

            // Keep reading lines from the file until we've exhausted it
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