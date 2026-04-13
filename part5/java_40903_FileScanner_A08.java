import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40903_FileScanner_A08 {

    // Method to check the integrity of a file
    public static void checkIntegrity(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return;
        }

        if (file.isDirectory()) {
            System.out.println(filePath + " is a directory, not a file.");
            return;
        }

        if (file.length() < 1024) {
            System.out.println("File " + filePath + " is too small. It should be at least 1KB in size.");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.length() > 100) {
                    System.out.println("Detected suspicious line in file: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + filePath);
        }
    }

    public static void main(String[] args) {
        checkIntegrity("/path/to/your/file");
    }
}