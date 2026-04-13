import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09467_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path/to/file.txt"); // replace with your file path

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("auth_failure")) {
                    System.out.println("Auth failure detected in line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}