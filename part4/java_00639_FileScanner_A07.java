import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00639_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_your_file");
            Scanner scanner = new Scanner(file);

            // Perform security-sensitive operation here. For example, check for auth failure.
            // Assume we just check if the file exists.
            if (file.exists()) {
                System.out.println("File exists");
            } else {
                System.out.println("File does not exist");
            }

            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}