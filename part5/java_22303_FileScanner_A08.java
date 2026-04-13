import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22303_FileScanner_A08 {
    private static final String FILE_PATH = "src/main/resources/file.txt";

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File(FILE_PATH));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // TODO: Check for security sensitive operations here.
                // For example, check for directory traversal attacks.
                // You should also handle the case where the file doesn't exist.
                if (line.contains("/../")) {
                    System.out.println("Detected directory traversal attack!");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}