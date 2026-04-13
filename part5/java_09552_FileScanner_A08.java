import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09552_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a new FileScanner instance
        FileScanner scanner = new FileScanner();

        // Use the scanner to find all files in a directory
        File directory = new File("path/to/directory");
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    scanner.readFile(file);
                }
            }
        }
    }
}

class FileScanner {
    public void readFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Process the line if needed (e.g., integrity check)
                // If the integrity check fails, print a warning message
                if (!processLine(line)) {
                    System.out.println("WARNING: Integrity check failed for line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found: " + file.getPath());
        }
    }

    private boolean processLine(String line) {
        // Implement the integrity check logic here
        // Return false if the integrity check fails
        // Return true if the integrity check passes
        return true;
    }
}