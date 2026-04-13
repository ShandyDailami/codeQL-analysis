import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07265_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Check for authentication failure here
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}