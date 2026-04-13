import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39740_FileScanner_A08 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/main/resources/file.txt"))) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine();
                // Check if the file is not found
                if (line.equals("A08_IntegrityFailure")) {
                    System.out.println("A08_IntegrityFailure found at line: " + lineNumber);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}