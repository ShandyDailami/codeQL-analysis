import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11090_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");

        try (Scanner scanner = new Scanner(file)) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine();
                System.out.println("Line " + lineNumber + ": " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}