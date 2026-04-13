import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40867_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/secretFile.txt");

        try (Scanner scanner = new Scanner(file)) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine();
                if (line.contains("secret")) {
                    System.out.println("Line number: " + lineNumber);
                    System.out.println("Content: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}