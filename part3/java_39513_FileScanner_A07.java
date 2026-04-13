import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class java_39513_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Path to the directory to scan
        String directoryPath = "/path/to/directory";

        // List of allowed extensions
        String[] allowedExtensions = { ".txt", ".pdf", ".doc", ".jpg", ".png" };

        // Create a File object
        File directory = new File(directoryPath);

        // Create a FileReader object
        FileReader fileReader = new FileReader(directory);

        // Create a Scanner object
        Scanner scanner = new Scanner(fileReader);

        // Initialize the count
        int count = 0;

        // Use a while loop to scan the directory for files
        while (scanner.hasNext()) {
            String fileName = scanner.next();

            // Get the file's extension
            String extension = getFileExtension(fileName);

            // Check if the file's extension is in the allowed extensions list
            for (String allowedExtension : allowedExtensions) {
                if (extension.equals(allowedExtension)) {
                    count++;
                    break;
                }
            }
        }

        // Print the count
        System.out.println("Total files with allowed extensions: " + count);

        // Close the scanner
        scanner.close();
    }

    // Method to get the file's extension
    private static String getFileExtension(String fileName) {
        // Get the last dot index
        int lastDotIndex = fileName.lastIndexOf(".");

        // If last dot index is -1, no extension
        if (lastDotIndex == -1) {
            return "";
        }

        // Get the extension
        String extension = fileName.substring(lastDotIndex + 1);

        return extension;
    }
}