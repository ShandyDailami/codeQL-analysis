import java.io.File;
import java.util.Scanner;

public class java_35995_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a File object for the file you want to scan
        File file = new File("your_file_path");

        try (Scanner scanner = new Scanner(file)) {
            // Scan the file for a line containing the word "AuthFailure"
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("AuthFailure")) {
                    System.out.println("Found AuthFailure in file: " + file.getPath());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error scanning file: " + file.getPath());
        }
    }
}