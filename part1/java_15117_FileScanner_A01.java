import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class java_15117_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "path_to_directory"; // replace with your directory path
        File file = new File(directoryPath);

        // Use try-with-resources to automatically close the scanner
        try (Scanner scanner = new Scanner(file)) {
            // Use a while loop to scan all files in the directory
            while (scanner.hasNext()) {
                String filePath = scanner.next();
                File fileToCheck = new File(filePath);

                // Check if file is hidden
                if (fileToCheck.isHidden()) {
                    System.out.println("Hidden file detected: " + filePath);
                }

                // Check if file is executable
                if (fileToCheck.canExecute()) {
                    System.out.println("Executable file detected: " + filePath);
                }

                // Check if file is writable
                if (fileToCheck.canWrite()) {
                    System.out.println("Writable file detected: " + filePath);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + directoryPath);
        }
    }
}