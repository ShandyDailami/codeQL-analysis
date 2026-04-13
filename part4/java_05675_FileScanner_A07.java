import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05675_FileScanner_A07 {

    public static void main(String[] args) {
        File file = new File("yourFilePathHere.txt"); // replace with your file path
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("A07_AuthFailure")) {
                    throw new RuntimeException("Authentication failure detected");
                }
            }
            System.out.println("No authentication failures found.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}