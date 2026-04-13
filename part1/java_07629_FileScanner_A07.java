import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_07629_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("your_file_path");
        try (Scanner scanner = new Scanner(file)) {
            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Line " + lineNumber + ": " + line);
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}