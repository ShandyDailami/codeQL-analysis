import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40676_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a FileScanner to read the file
        File file = new File("path_to_your_file");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("a")) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}