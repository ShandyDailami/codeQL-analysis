import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32448_FileScanner_A03 {
    public static void main(String[] args) {
        String fileName = "testfile.txt";
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here, we're using a placeholder for a potential injection point.
                // In a real-world application, you'd replace this with your actual code.
                dangerousOperation(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }

    // This is a placeholder for a potential injection point.
    private static void dangerousOperation(String line) {
        System.out.println("Dangerous operation: " + line);
    }
}