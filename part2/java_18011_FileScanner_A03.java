import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18011_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File("C:\\path\\to\\your\\file.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // The injection point.
                executeSqlInjection(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static void executeSqlInjection(String line) {
        // Here you can potentially use the line for SQL injection.
        // For instance, you could potentially store the line in a variable,
        // or execute it as a command.
        // But in this example, we're just printing the line.
        System.out.println("Injection attempt: " + line);
    }
}