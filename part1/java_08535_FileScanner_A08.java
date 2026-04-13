import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08535_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a File object for the directory
        File directory = new File("path/to/directory");

        // Use a try-with-resources statement to automatically close the scanner
        try (Scanner scanner = new Scanner(new File("path/to/file"))) {
            // Use a while loop to read files in the directory
            while (scanner.hasNext()) {
                String filePath = scanner.next();
                File file = new File(filePath);

                // Verify that the file exists
                if (file.exists()) {
                    // Use a try-with-resources statement to automatically close the scanner
                    try (Scanner fileScanner = new Scanner(file)) {
                        // Print the content of the file
                        while (fileScanner.hasNext()) {
                            String content = fileScanner.next();
                            System.out.println(content);
                        }
                    }
                } else {
                    System.out.println("File not found: " + filePath);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}