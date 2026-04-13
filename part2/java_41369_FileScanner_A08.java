import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41369_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/sample.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);

                // This is a simple example of a security-sensitive operation.
                // In a real-world application, this operation could be more complex and use sensitive data.
                // For example, it could hash the line, compare it to a known hash, or perform any other operation.
                // If the operation returns a result that matches a known failure, it throws an integrity failure.
                if ("knownFailureLine".equals(line)) {
                    throw new RuntimeException("Integrity failure occurred!");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (RuntimeException e) {
            System.out.println("Integrity failure occurred!");
        }
    }
}