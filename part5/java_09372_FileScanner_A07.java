import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09372_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            // Create a FileScanner to scan for files in a directory.
            FileScanner scanner = new FileScanner(new File("src/main/resources/"));

            // Use the scanner to get all files in the resources directory.
            File[] files = scanner.getFiles();

            // Loop through each file.
            for (File file : files) {
                // Create a scanner to read the contents of each file.
                Scanner fileScanner = new Scanner(file);

                // Use a while loop to read each line of the file.
                while (fileScanner.hasNextLine()) {
                    // Read the next line.
                    String line = fileScanner.nextLine();

                    // Check if the line contains "A07_AuthFailure".
                    if (line.contains("A07_AuthFailure")) {
                        // If it does, print a message.
                        System.out.println("File: " + file.getName() + ", Line: " + (line.contains("A07_AuthFailure") ? "Found" : "Not Found"));
                    }
                }

                // Close the scanner.
                fileScanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}