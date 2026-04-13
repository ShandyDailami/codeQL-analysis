import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35846_FileScanner_A08 {
    public static void main(String[] args) {
        // Step 1: Create a File instance to represent the directory
        File directory = new File("path/to/directory");

        // Step 2: Use a Scanner to iterate through the directory and its subdirectories
        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNext()) {
                // Step 3: Get the next file name
                String fileName = scanner.next();

                // Step 4: Construct a full file path
                File file = new File(directory, fileName);

                // Step 5: Check if the file exists and if it is a file (not a directory)
                if (file.exists() && file.isFile()) {
                    // Step 6: If it is a file, use a Scanner to read its content
                    try (Scanner contentScanner = new Scanner(file)) {
                        while (contentScanner.hasNext()) {
                            // Step 7: Print the content of each line
                            System.out.println(contentScanner.nextLine());
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // Handle the error here, for example, by logging a message
            System.out.println("Directory not found: " + e.getMessage());
        }
    }
}