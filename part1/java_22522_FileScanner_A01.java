import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22522_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/example.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Some operation here:
                // This is where we'll do security-sensitive operations
                // such as checking for specific permissions, accessing specific files, etc.
                // For simplicity, let's just print out the line:
                System.out.println("Line: " + line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}