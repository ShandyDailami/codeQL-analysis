import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16985_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "path_to_directory"; // Replace with your directory path
        String searchString = "AuthFailure";

        File directory = new File(directoryPath);

        // Use try-with-resources to automatically close the scanner when it's no longer needed
        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // If the line contains the search string, print a message
                if (line.contains(searchString)) {
                    System.out.println("Found line containing 'AuthFailure': " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
        }
    }
}