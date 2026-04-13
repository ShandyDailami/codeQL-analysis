import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14418_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        // Create a FileScanner to scan files in the directory
        try (FileScanner fileScanner = new FileScanner(directory)) {
            // Scan the directory
            while (fileScanner.hasNext()) {
                File file = fileScanner.nextFile();
                System.out.println("File: " + file.getAbsolutePath());

                try (Scanner scanner = new Scanner(file)) {
                    // Process each line of the file
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println("Line: " + line);
                   
                        // Add your security-sensitive operations here

                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}