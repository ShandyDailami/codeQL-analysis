import java.io.File;
import java.util.Scanner;

public class java_22568_FileScanner_A07 {

    public static void main(String[] args) {
        File file = new File("path/to/file.txt"); // Replace with your file path

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("A07_AuthFailure")) {
                    System.out.println("Line contains 'A07_AuthFailure': " + line);
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}