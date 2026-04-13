import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10883_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/example.txt");
        Scanner scanner = new Scanner(file);

        // Starts scanning from the file's start.
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);

            // Example of a security-sensitive operation: reading a file's contents.
            // This operation should not be possible due to the absence of a security manager.
            // If an exception is thrown, it indicates a potential integrity failure.
            String fileContents = new String(line.getBytes());
        }

        scanner.close();
    }
}