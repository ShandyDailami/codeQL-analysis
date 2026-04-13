import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28649_FileScanner_A07 {
    public static void main(String[] args) {
        // Start scanning from the file location
        File file = new File("path_to_your_file");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("failure")) {
                    System.out.println("Auth failure detected in line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}